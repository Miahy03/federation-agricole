package com.example.federation.repository;

import com.example.federation.entity.Mandat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MandatRepository extends JpaRepository<Mandat, Long> {

    List<Mandat> findByMembreIdAndPoste(Long membreId, String poste);

    List<Mandat> findByCollectiviteIdAndPoste(Long collectiviteId, String poste);
}