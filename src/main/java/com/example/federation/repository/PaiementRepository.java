package com.example.federation.repository;

import com.example.federation.entity.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Payement, Long> {}