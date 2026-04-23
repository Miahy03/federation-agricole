// commit: fix(account-service): enforce single cash account per collectivity

package com.example.federation.service;

import com.example.federation.entity.Account;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account create(Account account) {

        if ("CASH".equalsIgnoreCase(account.getType())) {

            boolean exists = repo.findAll().stream()
                    .anyMatch(a -> "CASH".equalsIgnoreCase(a.getType()));

            if (exists) {
                throw new RuntimeException("Only one CASH account allowed");
            }
        }

        return repo.save(account);
    }

    public List<Account> getAll() {
        return repo.findAll();
    }
}