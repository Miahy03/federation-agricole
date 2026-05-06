package com.example.federation.repository;

import com.example.federation.entity.Collectivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectivityRepository extends JpaRepository<Collectivity, String> {

    boolean existsByNumero(String numero);

    boolean existsByNom(String nom);
}