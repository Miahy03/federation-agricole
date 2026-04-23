package com.example.federation.service;

import com.example.federation.entity.Payment;
import com.example.federation.repository.PaymentRepository;
import com.example.federation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;
    private final MemberRepository memberRepo;

    public PaymentService(PaymentRepository paymentRepo, MemberRepository memberRepo) {
        this.paymentRepo = paymentRepo;
        this.memberRepo = memberRepo;
    }

    public Payment createPayment(String memberId, double amount) {
        return memberRepo.findById(memberId)
                .map(member -> {
                    Payment p = new Payment();
                    p.setMember(member);
                    p.setAmount(amount);
                    return paymentRepo.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public List<Payment> pay(String memberId, List<Payment> payments) {
        return payments.stream()
                .map(p -> createPayment(memberId, p.getAmount()))
                .toList();
    }
}