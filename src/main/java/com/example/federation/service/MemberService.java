package com.example.federation.service;

import com.example.federation.dto.MemberRequest;
import com.example.federation.entity.Collectivity;
import com.example.federation.entity.Member;
import com.example.federation.entity.Sponsorship;
import com.example.federation.repository.MemberRepository;
import com.example.federation.repository.SponsorshipRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepo;
    private final SponsorshipRepository sponsorshipRepo;

    public MemberService(MemberRepository memberRepo,
                         SponsorshipRepository sponsorshipRepo) {
        this.memberRepo = memberRepo;
        this.sponsorshipRepo = sponsorshipRepo;
    }

    public Member create(MemberRequest request) {

        if (request.getSponsorIds() == null || request.getSponsorIds().size() < 2) {
            throw new RuntimeException("At least 2 sponsors required");
        }

        Member m = new Member();
        m.setFirstName(request.getFirstName());
        m.setLastName(request.getLastName());
        m.setGender(request.getGender());
        m.setAddress(request.getAddress());
        m.setJob(request.getJob());
        m.setPhone(request.getPhone());
        m.setEmail(request.getEmail());

        if (request.getBirthDate() != null) {
            m.setBirthDate(LocalDate.parse(request.getBirthDate()));
        }

        if (request.getAdmissionDate() != null) {
            m.setAdmissionDate(LocalDate.parse(request.getAdmissionDate()));
        }

        m.setJoinDate(LocalDate.now());

        Collectivity c = new Collectivity();
        c.setId(request.getCollectivityId());
        m.setCollectivity(c);

        Member saved = memberRepo.save(m);

        List<Member> sponsors = memberRepo.findAllById(request.getSponsorIds());

        if (sponsors.size() < 2) {
            throw new RuntimeException("Sponsors not found in database (check IDs)");
        }

        for (Member sponsor : sponsors) {
            Sponsorship s = new Sponsorship();
            s.setCandidate(saved);
            s.setSponsor(sponsor);
            s.setCollectivity(c);
            s.setRelationship("SPONSOR");

            sponsorshipRepo.save(s);
        }

        return saved;
    }
}