package com.example.federation.service;

import com.example.federation.entity.Mandat;
import com.example.federation.repository.MandatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MandatService {

    @Autowired
    private MandatRepository repo;

    public Mandat creerMandat(Mandat m) {

        if (m == null) {
            throw new RuntimeException("Mandat invalide");
        }

        if (m.getMembre() == null || m.getMembre().getId() == null) {
            throw new RuntimeException("Membre obligatoire");
        }

        if (m.getCollectivite() == null || m.getCollectivite().getId() == null) {
            throw new RuntimeException("Collectivité obligatoire");
        }

        if (m.getPoste() == null) {
            throw new RuntimeException("Poste obligatoire");
        }


        List<Mandat> anciens = repo.findByMembreIdAndPoste(
                m.getMembre().getId(),
                m.getPoste()
        );

        if (anciens.size() >= 2) {
            throw new RuntimeException("Maximum 2 mandats pour ce poste");
        }

        if ("PRESIDENT".equalsIgnoreCase(m.getPoste())) {

            List<Mandat> existants = repo.findByCollectiviteIdAndPoste(
                    m.getCollectivite().getId(),
                    "PRESIDENT"
            );

            if (!existants.isEmpty()) {
                throw new RuntimeException("Un président existe déjà");
            }
        }

        return repo.save(m);
    }
}