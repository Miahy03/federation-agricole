package com.example.federation.repository;

import com.example.federation.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByCollectivityId(Long collectivityId);
}