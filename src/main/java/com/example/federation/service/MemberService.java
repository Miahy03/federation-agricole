package com.example.federation.service;

import com.example.federation.entity.Member;
import com.example.federation.repository.MemberRepository;
import com.example.federation.dto.AdhesionRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {

    private final MemberRepository memberRepo;

    public MemberService(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Member createMember(AdhesionRequest request) {
        Member m = new Member();
        m.setNom(request.getNom());
        m.setPrenom(request.getPrenom());
        m.setDateNaissance(request.getDateNaissance());
        m.setDateAdhesion(LocalDate.now());
        m.setGenre(request.getGenre());
        m.setAdresse(request.getAdresse());
        m.setMetier(request.getMetier());
        m.setTelephone(request.getTelephone());
        m.setEmail(request.getEmail());
        m.setPoste(request.getPoste());

        return memberRepo.save(m);
    }
}