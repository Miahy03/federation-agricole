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

        if (c.getCity() == null || c.getSpecialty() == null) {
            throw new RuntimeException("City and specialty required");
        }

        c.setCreationDate(LocalDate.now());

        return repo.save(c);
    }

    public Collectivity assignNumberAndName(Long id, String number, String name) {

        Collectivity c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Collectivity not found"));

        if (c.getNumber() != null || c.getName() != null) {
            throw new RuntimeException("Already assigned");
        }

        if (repo.existsByName(name)) {
            throw new RuntimeException("Name already exists");
        }

        c.setNumber(number);
        c.setName(name);

        return repo.save(c);
    }
}