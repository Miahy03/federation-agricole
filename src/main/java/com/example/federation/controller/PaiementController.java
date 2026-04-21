package com.example.federation.controller;

import com.example.federation.entity.Paiement;
import com.example.federation.service.PaiementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paiements")
public class PaiementController {

    private final PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }

    @PostMapping
    public Paiement payer(@RequestBody Paiement p) {
        return service.payer(p);
    }
}