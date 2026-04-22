package com.example.federation.repository;

import com.example.federation.entity.Collectivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectivityRepository extends JpaRepository<Collectivity, Long> {
    boolean existsByName(String name);
}