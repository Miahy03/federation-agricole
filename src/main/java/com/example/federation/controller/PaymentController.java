package com.example.federation.controller;

import com.example.federation.entity.Payment;
import com.example.federation.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/{id}/payments")
    public List<Payment> pay(
            @PathVariable Long id,
            @RequestBody List<Payment> payments
    ) {
        return service.pay(id, payments);
    }
}