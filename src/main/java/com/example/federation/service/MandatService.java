package com.example.federation.service;

import com.example.federation.entity.Mandat;
import com.example.federation.repository.MandatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MandatService {

    private final MandatRepository repo;

    public MandatService(MandatRepository repo) {
        this.repo = repo;
    }

    public Mandat create(Mandat mandat) {

        if (mandat.getDateFin().isBefore(mandat.getDateDebut())) {
            throw new RuntimeException("Invalid mandate dates");
        }

        return repo.save(mandat);
    }
}