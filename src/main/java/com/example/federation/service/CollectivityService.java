package com.example.federation.service;

import com.example.federation.entity.Collectivity;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.exceptions.ConflictException;
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

        if (c.getName() == null || c.getName().isBlank()) {
            throw new BadRequestException("Name required");
        }

        if (repo.existsByName(c.getName())) {
            throw new ConflictException("Collectivity already exists");
        }

        c.setCreationDate(LocalDate.now());

        return repo.save(c);
    }
}