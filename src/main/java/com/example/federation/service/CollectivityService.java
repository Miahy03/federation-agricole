package com.example.federation.service;

import com.example.federation.dto.*;
import com.example.federation.entity.*;
import com.example.federation.repository.CollectivityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CollectivityService {

    private final CollectivityRepository repo;

    public CollectivityService(CollectivityRepository repo) {
        this.repo = repo;
    }

    public CollectivityResponse create(CollectivityRequest dto) {

        Collectivity c = new Collectivity();
        c.setId(UUID.randomUUID().toString());
        c.setLocalite(dto.getLocalite());
        c.setSpecialite(dto.getSpecialite());

        List<Member> members = new ArrayList<>();

        if (dto.getMembres() != null) {
            for (MemberRequest m : dto.getMembres()) {

                Member member = new Member();
                member.setId(UUID.randomUUID().toString());

                member.setNom(m.getNom());
                member.setPrenom(m.getPrenom());
                member.setDateNaissance(m.getDateNaissance());
                member.setDateAdhesion(m.getDateAdhesion());
                member.setGenre(m.getGenre());
                member.setAdresse(m.getAdresse());
                member.setMetier(m.getMetier());
                member.setTelephone(m.getTelephone());
                member.setEmail(m.getEmail());
                member.setPoste(m.getPoste());

                member.setCollectivity(c);

                members.add(member);
            }
        }

        c.setMembres(members);

        Collectivity saved = repo.save(c);

        CollectivityResponse res = new CollectivityResponse();
        res.setId(saved.getId());
        res.setLocalite(saved.getLocalite());
        res.setSpecialite(saved.getSpecialite());

        return res;
    }

    public CollectivityResponse getById(String id) {

        Collectivity c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Collectivity not found"));

        CollectivityResponse res = new CollectivityResponse();
        res.setId(c.getId());
        res.setLocalite(c.getLocalite());
        res.setSpecialite(c.getSpecialite());

        return res;
    }
}