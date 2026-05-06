package com.example.federation.service;

import com.example.federation.dto.CollectivityStatisticsResponse;
import com.example.federation.dto.FederationStatisticsResponse;
import com.example.federation.entity.Collectivity;
import com.example.federation.entity.Member;
import com.example.federation.entity.Payment;
import com.example.federation.repository.CollectivityRepository;
import com.example.federation.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    private final CollectivityRepository collectivityRepository;
    private final PaymentRepository paymentRepository;

    public StatisticsService(CollectivityRepository collectivityRepository,
                             PaymentRepository paymentRepository) {
        this.collectivityRepository = collectivityRepository;
        this.paymentRepository = paymentRepository;
    }

    // GET /collectivities/{id}/statistics
    public CollectivityStatisticsResponse getCollectivityStatistics(String collectivityId,
                                                                    LocalDate startDate,
                                                                    LocalDate endDate) {

        Collectivity collectivity = collectivityRepository.findById(collectivityId)
                .orElseThrow(() -> new RuntimeException("Collectivity not found: " + collectivityId));

        List<Member> members = collectivity.getMembres();
        List<CollectivityStatisticsResponse.MemberStatisticsDto> memberStats = new ArrayList<>();
        double totalCollected = 0;

        for (Member member : members) {
            List<Payment> payments = paymentRepository.findByMemberAndDateBetween(member, startDate, endDate);

            double amountCollected = 0;
            if (payments != null) {
                for (Payment p : payments) {
                    if (p != null && p.getAmount() > 0) {
                        amountCollected += p.getAmount();
                    }
                }
            }
            totalCollected += amountCollected;

            double potentialUnpaid = calculatePotentialUnpaid(member, startDate, endDate);

            CollectivityStatisticsResponse.MemberStatisticsDto dto = new CollectivityStatisticsResponse.MemberStatisticsDto();
            dto.setMemberId(member.getId());
            dto.setMemberName(member.getPrenom() + " " + member.getNom());
            dto.setAmountCollected(amountCollected);
            dto.setPotentialUnpaidAmount(potentialUnpaid);

            memberStats.add(dto);
        }

        double totalUnpaid = 0;
        for (CollectivityStatisticsResponse.MemberStatisticsDto dto : memberStats) {
            totalUnpaid += dto.getPotentialUnpaidAmount();
        }

        CollectivityStatisticsResponse response = new CollectivityStatisticsResponse();
        response.setCollectivityId(collectivity.getId());
        response.setCollectivityName(collectivity.getNom());
        response.setCollectivityNumber(collectivity.getNumero());

        CollectivityStatisticsResponse.PeriodDto period = new CollectivityStatisticsResponse.PeriodDto();
        period.setStartDate(startDate.toString());
        period.setEndDate(endDate.toString());
        response.setPeriod(period);

        response.setMemberStatistics(memberStats);

        CollectivityStatisticsResponse.SummaryDto summary = new CollectivityStatisticsResponse.SummaryDto();
        summary.setTotalCollected(totalCollected);
        summary.setTotalUnpaid(totalUnpaid);
        summary.setActiveMembersCount(members.size());
        response.setSummary(summary);

        return response;
    }

    // GET /collectivities/statistics
    public FederationStatisticsResponse getFederationStatistics(LocalDate startDate, LocalDate endDate) {

        List<Collectivity> allCollectivities = collectivityRepository.findAll();
        List<FederationStatisticsResponse.CollectivityStatsDto> collectivityStats = new ArrayList<>();
        int totalNewMembers = 0;
        int totalActiveMembers = 0;

        for (Collectivity collectivity : allCollectivities) {
            List<Member> members = collectivity.getMembres();
            if (members == null) members = new ArrayList<>();

            int newMembers = 0;
            for (Member member : members) {
                if (member != null && member.getDateAdhesion() != null &&
                        !member.getDateAdhesion().isBefore(startDate) &&
                        !member.getDateAdhesion().isAfter(endDate)) {
                    newMembers++;
                }
            }
            totalNewMembers += newMembers;
            totalActiveMembers += members.size();

            double percentageUpToDate = calculatePercentageUpToDate(collectivity, startDate, endDate);

            FederationStatisticsResponse.CollectivityStatsDto dto = new FederationStatisticsResponse.CollectivityStatsDto();
            dto.setCollectivityId(collectivity.getId());
            String name = collectivity.getNom();
            if (name == null || name.isEmpty()) {
                name = collectivity.getNumero();
            }
            if (name == null || name.isEmpty()) {
                name = "Collectivité " + collectivity.getId();
            }
            dto.setCollectivityName(name);
            dto.setPercentageMembersUpToDate(percentageUpToDate);
            dto.setNewMembersCount(newMembers);
            dto.setTotalActiveMembers(members.size());

            collectivityStats.add(dto);
        }

        double globalAverage = 0;
        for (FederationStatisticsResponse.CollectivityStatsDto dto : collectivityStats) {
            globalAverage += dto.getPercentageMembersUpToDate();
        }
        if (collectivityStats.size() > 0) {
            globalAverage = globalAverage / collectivityStats.size();
        }

        FederationStatisticsResponse response = new FederationStatisticsResponse();

        FederationStatisticsResponse.PeriodDto period = new FederationStatisticsResponse.PeriodDto();
        period.setStartDate(startDate.toString());
        period.setEndDate(endDate.toString());
        response.setPeriod(period);

        response.setCollectivitiesStats(collectivityStats);

        FederationStatisticsResponse.SummaryDto summary = new FederationStatisticsResponse.SummaryDto();
        summary.setGlobalAveragePercentage(Math.round(globalAverage * 100.0) / 100.0);
        summary.setTotalNewMembers(totalNewMembers);
        summary.setTotalActiveMembers(totalActiveMembers);
        response.setSummary(summary);

        return response;
    }

    private double calculatePotentialUnpaid(Member member, LocalDate startDate, LocalDate endDate) {
        try {
            List<Payment> payments = paymentRepository.findByMemberAndDateBetween(member, startDate, endDate);
            double totalPaid = 0;
            if (payments != null) {
                for (Payment p : payments) {
                    if (p != null) {
                        totalPaid += p.getAmount();
                    }
                }
            }
            double expectedAmount = 200000.0;
            double unpaid = expectedAmount - totalPaid;
            if (unpaid < 0) unpaid = 0;
            return unpaid;
        } catch (Exception e) {
            return 200000.0; // valeur par défaut si erreur
        }
    }

    private double calculatePercentageUpToDate(Collectivity collectivity, LocalDate startDate, LocalDate endDate) {
        List<Member> members = collectivity.getMembres();
        if (members == null || members.isEmpty()) return 0.0;

        int upToDateCount = 0;
        for (Member member : members) {
            if (isMemberUpToDate(member, startDate, endDate)) {
                upToDateCount++;
            }
        }

        double percentage = (upToDateCount * 100.0) / members.size();
        return Math.round(percentage * 100.0) / 100.0;
    }

    private boolean isMemberUpToDate(Member member, LocalDate startDate, LocalDate endDate) {
        try {
            List<Payment> payments = paymentRepository.findByMemberAndDateBetween(member, startDate, endDate);
            double totalPaid = 0;
            if (payments != null) {
                for (Payment p : payments) {
                    if (p != null) {
                        totalPaid += p.getAmount();
                    }
                }
            }
            double expectedAmount = 200000.0;
            return totalPaid >= expectedAmount;
        } catch (Exception e) {
            return false;
        }
    }
}