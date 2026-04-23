package com.example.federation.controller;

import com.example.federation.entity.Payment;
import com.example.federation.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{memberId}")
    public List<Payment> pay(
            @PathVariable String memberId,
            @RequestBody List<Payment> payments) {

        List<Payment> savedPayments = new ArrayList<>();
        for (Payment p : payments) {
            savedPayments.add(paymentService.createPayment(memberId, p.getAmount()));
        }
        return savedPayments;
    }
}