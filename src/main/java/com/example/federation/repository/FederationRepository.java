package com.example.federation.repository;

import com.example.federation.entity.Federation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FederationRepository extends JpaRepository<Federation, Long> {
}