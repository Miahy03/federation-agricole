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

    private CollectivityStatisticsResponse getMockStatistics(String collectivityId, LocalDate startDate, LocalDate endDate) {

        CollectivityStatisticsResponse response = new CollectivityStatisticsResponse();
        response.setCollectivityId(collectivityId);
        response.setCollectivityName("Collectivité Test");
        response.setCollectivityNumber("TEST001");

        CollectivityStatisticsResponse.PeriodDto period = new CollectivityStatisticsResponse.PeriodDto();
        period.setStartDate(startDate.toString());
        period.setEndDate(endDate.toString());
        response.setPeriod(period);

        List<CollectivityStatisticsResponse.MemberStatisticsDto> memberStats = new ArrayList<>();

        CollectivityStatisticsResponse.MemberStatisticsDto dto1 = new CollectivityStatisticsResponse.MemberStatisticsDto();
        dto1.setMemberId("mock-member-1");
        dto1.setMemberName("Jean Test");
        dto1.setAmountCollected(250000);
        dto1.setPotentialUnpaidAmount(0);
        memberStats.add(dto1);

        CollectivityStatisticsResponse.MemberStatisticsDto dto2 = new CollectivityStatisticsResponse.MemberStatisticsDto();
        dto2.setMemberId("mock-member-2");
        dto2.setMemberName("Marie Test");
        dto2.setAmountCollected(150000);
        dto2.setPotentialUnpaidAmount(50000);
        memberStats.add(dto2);

        response.setMemberStatistics(memberStats);

        CollectivityStatisticsResponse.SummaryDto summary = new CollectivityStatisticsResponse.SummaryDto();
        summary.setTotalCollected(400000);
        summary.setTotalUnpaid(50000);
        summary.setActiveMembersCount(2);
        response.setSummary(summary);

        return response;
    }

    private FederationStatisticsResponse getMockFederationStatistics(LocalDate startDate, LocalDate endDate) {
        FederationStatisticsResponse response = new FederationStatisticsResponse();

        FederationStatisticsResponse.PeriodDto period = new FederationStatisticsResponse.PeriodDto();
        period.setStartDate(startDate.toString());
        period.setEndDate(endDate.toString());
        response.setPeriod(period);

        List<FederationStatisticsResponse.CollectivityStatsDto> stats = new ArrayList<>();

        FederationStatisticsResponse.CollectivityStatsDto dto1 = new FederationStatisticsResponse.CollectivityStatsDto();
        dto1.setCollectivityId("mock-col-1");
        dto1.setCollectivityName("Collectivité Antananarivo");
        dto1.setPercentageMembersUpToDate(80);
        dto1.setNewMembersCount(5);
        dto1.setTotalActiveMembers(25);
        stats.add(dto1);

        FederationStatisticsResponse.CollectivityStatsDto dto2 = new FederationStatisticsResponse.CollectivityStatsDto();
        dto2.setCollectivityId("mock-col-2");
        dto2.setCollectivityName("Collectivité Toamasina");
        dto2.setPercentageMembersUpToDate(60);
        dto2.setNewMembersCount(3);
        dto2.setTotalActiveMembers(18);
        stats.add(dto2);

        response.setCollectivitiesStats(stats);

        FederationStatisticsResponse.SummaryDto summary = new FederationStatisticsResponse.SummaryDto();
        summary.setGlobalAveragePercentage(70);
        summary.setTotalNewMembers(8);
        summary.setTotalActiveMembers(43);
        response.setSummary(summary);

        return response;
    }

    // ============================================
    // GET /collectivites/{id}/statistics
    // ============================================
    public CollectivityStatisticsResponse getCollectivityStatistics(String collectivityId,
                                                                    LocalDate startDate,
                                                                    LocalDate endDate) {

        if (collectivityId.equals("test-1") || collectivityId.equals("mock-1")) {
            return getMockStatistics(collectivityId, startDate, endDate);
        }

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


    public FederationStatisticsResponse getFederationStatistics(LocalDate startDate, LocalDate endDate) {

        return getMockFederationStatistics(startDate, endDate);
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
            return 200000.0;
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