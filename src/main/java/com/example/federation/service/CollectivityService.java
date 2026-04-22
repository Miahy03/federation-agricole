package com.example.federation.service;

import com.example.federation.entity.Collectivity;
import com.example.federation.repository.CollectivityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CollectivityService {

    private final CollectivityRepository repo;

    public CollectivityService(CollectivityRepository repo) {
        this.repo = repo;
    }

    public Collectivity create(Collectivity c) {

        if (c.getCity() == null || c.getSpeciality() == null) {
            throw new RuntimeException("City and speciality required");
        }

        c.setCreationDate(LocalDate.now());

        return repo.save(c);
    }
}