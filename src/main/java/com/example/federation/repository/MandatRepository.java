package com.example.federation.repository;

import com.example.federation.entity.Mandat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandatRepository extends JpaRepository<Mandat, Long> {
}