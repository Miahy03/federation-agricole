package com.example.federation.service;

import com.example.federation.entity.Account;
import com.example.federation.entity.Member;
import com.example.federation.entity.Payment;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.exceptions.NotFoundException;
import com.example.federation.repository.AccountRepository;
import com.example.federation.repository.MemberRepository;
import com.example.federation.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repo;
    private final MemberRepository memberRepo;
    private final AccountRepository accountRepo;

    public PaymentService(
            PaymentRepository repo,
            MemberRepository memberRepo,
            AccountRepository accountRepo
    ) {
        this.repo = repo;
        this.memberRepo = memberRepo;
        this.accountRepo = accountRepo;
    }

    public List<Payment> pay(Long memberId, List<Payment> payments) {

        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Member not found"));

        for (Payment p : payments) {

            if (p.getAmount() <= 0) {
                throw new BadRequestException("Invalid amount");
            }

            if (p.getMember() == null || p.getCollectivity() == null) {
                throw new BadRequestException("Member and Collectivity required");
            }

            p.setMember(member);
            p.setDate(LocalDate.now());

        }

        return repo.saveAll(payments);
    }
}