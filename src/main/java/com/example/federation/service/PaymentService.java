package com.example.federation.service;

import com.example.federation.entity.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentService {

    public Payment pay(Payment p) {
        p.setDate(LocalDate.now());
        return p;
    }
}