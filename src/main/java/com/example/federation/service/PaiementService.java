package com.example.federation.service;

import com.example.federation.entity.*;
import com.example.federation.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class PaiementService {

    private final PaiementRepository repo;

    public PaiementService(PaiementRepository repo) {
        this.repo = repo;
    }

    public Paiement payer(Paiement p) {
        return repo.save(p);
    }
}