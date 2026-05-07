package com.example.federation.repository;

import com.example.federation.entity.Contribution;
import com.example.federation.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, String> {

    List<Contribution> findByCollectivityId(String collectivityId);

    List<Contribution> findByCollectivityIdAndStatus(String collectivityId, PaymentStatus status);
}