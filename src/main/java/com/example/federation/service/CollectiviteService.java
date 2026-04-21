package com.example.federation.service;
import com.example.federation.entity.Collectivite;
import com.example.federation.repository.CollectiviteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CollectiviteService {

    private final CollectiviteRepository repo;

    public CollectiviteService(CollectiviteRepository repo) {
        this.repo = repo;
    }
    public List<Collectivite> all() {
        return repo.findAll();
    }
    public Collectivite create(Collectivite c) {

        if (c.getMembres() != null && c.getMembres().size() < 10) {
            throw new RuntimeException("Minimum 10 membres requis");
        }

        return repo.save(c);
    }
}
