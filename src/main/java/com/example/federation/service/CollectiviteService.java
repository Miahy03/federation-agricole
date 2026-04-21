package com.example.federation.service;
import com.example.federation.entity.Collectivity;
import com.example.federation.repository.CollectiviteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectiviteService {

    private final CollectiviteRepository repo;

    public CollectiviteService(CollectiviteRepository repo) {
        this.repo = repo;
    }
    public List<Collectivity> all() {
        return repo.findAll();
    }
    public Collectivity create(Collectivity c) {

        if (c.getMembres() != null && c.getMembres().size() < 10) {
            throw new RuntimeException("Minimum 10 membres requis");
        }

        return repo.save(c);
    }
}
