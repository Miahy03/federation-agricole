package com.example.federation.service;

import com.example.federation.entity.*;
import com.example.federation.repository.*;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContributionService {

    private final ContributionRepository contributionRepo;
    private final MemberRepository memberRepo;
    private final CollectivityRepository collectivityRepo;

    public ContributionService(ContributionRepository contributionRepo,
                               MemberRepository memberRepo,
                               CollectivityRepository collectivityRepo) {
        this.contributionRepo = contributionRepo;
        this.memberRepo = memberRepo;
        this.collectivityRepo = collectivityRepo;
    }

    public Contribution create(Long memberId, Long collectivityId, double amount) {

        if (amount <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }

        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Member not found"));

        Collectivity collectivity = collectivityRepo.findById(collectivityId)
                .orElseThrow(() -> new NotFoundException("Collectivity not found"));

        Contribution contribution = new Contribution();
        contribution.setMember(member);
        contribution.setCollectivity(collectivity);
        contribution.setAmount(amount);
        contribution.setDueDate(LocalDate.now().plusMonths(1));
        contribution.setStatus(PaymentStatus.UNPAID);

        return contributionRepo.save(contribution);
    }
}