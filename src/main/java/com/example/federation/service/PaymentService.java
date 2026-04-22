package com.example.federation.service;

import com.example.federation.entity.Payment;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment pay(Payment p) {

        if (p.getAmount() <= 0) {
            throw new BadRequestException("Invalid amount");
        }

        if (p.getMember() == null || p.getCollectivity() == null) {
            throw new BadRequestException("Member and Collectivity required");
        }

        p.setDate(LocalDate.now());

        return repo.save(p);
    }
}