package com.example.federation.service;

import com.example.federation.entity.Account;
import com.example.federation.entity.Collectivity;
import com.example.federation.exceptions.NotFoundException;
import com.example.federation.repository.AccountRepository;
import com.example.federation.repository.CollectivityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CollectivityService {

    private final CollectivityRepository repo;
    private final AccountRepository accountRepo;

    public CollectivityService(CollectivityRepository repo,
                               AccountRepository accountRepo) {
        this.repo = repo;
        this.accountRepo = accountRepo;
    }

    public Collectivity create(Collectivity c) {
        c.setCreationDate(LocalDate.now());
        return repo.save(c);
    }

    public Collectivity getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Collectivity not found"));
    }

    public List<Account> getAccounts(Long id, LocalDate at) {
        Collectivity c = getById(id);

        return accountRepo.findAll()
                .stream()
                .filter(a -> a.getCollectivity() != null
                        && a.getCollectivity().getId().equals(c.getId()))
                .toList();
    }
}