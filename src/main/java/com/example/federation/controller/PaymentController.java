package com.example.federation.controller;

import com.example.federation.entity.Payment;
import com.example.federation.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Payment pay(@RequestBody Payment p) {
        return service.pay(p);
    }
}