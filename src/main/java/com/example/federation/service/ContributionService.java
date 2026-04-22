package com.example.federation.service;

import com.example.federation.entity.*;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.repository.ContributionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContributionService {

    private final ContributionRepository repo;

    public ContributionService(ContributionRepository repo) {
        this.repo = repo;
    }

    public Contribution create(Member m, Collectivity c, double amount) {

        if (amount <= 0) {
            throw new BadRequestException("Invalid contribution amount");
        }

        Contribution ct = new Contribution();
        ct.setMember(m);
        ct.setCollectivity(c);
        ct.setAmount(amount);
        ct.setDueDate(LocalDate.now().plusMonths(1));
        ct.setStatus(PaymentStatus.UNPAID);

        return repo.save(ct);
    }
}