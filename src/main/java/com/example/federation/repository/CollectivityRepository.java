package com.example.federation.repository;

import com.example.federation.entity.Collectivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectivityRepository extends JpaRepository<Collectivity, String> {
    Optional<Collectivity> findByNumero(String numero);
    Optional<Collectivity> findByNom(String nom);
}