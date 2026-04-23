package com.example.federation.repository;

import com.example.federation.entity.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, String> {
    // Changement : Long → String
}