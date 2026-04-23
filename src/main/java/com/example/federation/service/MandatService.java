package com.example.federation.service;

import com.example.federation.entity.*;
import com.example.federation.repository.*;
import com.example.federation.dto.SponsorshipRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MandatService {

    private final MemberRepository memberRepo;
    private final SponsorshipRepository sponsorshipRepo;
    private final CollectivityRepository collectivityRepo;

    public MandatService(MemberRepository memberRepo,
                         SponsorshipRepository sponsorshipRepo,
                         CollectivityRepository collectivityRepo) {
        this.memberRepo = memberRepo;
        this.sponsorshipRepo = sponsorshipRepo;
        this.collectivityRepo = collectivityRepo;
    }

    @Transactional
    public void validateSponsors(String memberId, List<SponsorshipRequest> sponsors, String collectivityId) {

        Member newMember = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        for (SponsorshipRequest dto : sponsors) {
            Member sponsor = memberRepo.findById(dto.getSponsorId())
                    .orElseThrow(() -> new RuntimeException("Sponsor not found: " + dto.getSponsorId()));

            if (!"CONFIRME".equals(sponsor.getPoste())) {
                throw new RuntimeException("Sponsor must be a confirmed member");
            }

            Sponsorship s = new Sponsorship();
            s.setSponsor(sponsor);
            s.setMember(newMember);
            s.setRelation(dto.getRelationship());
            s.setCreatedAt(LocalDateTime.now());

            // Correction : setCollectivity existe maintenant dans Sponsorship
            Collectivity collectivity = collectivityRepo.findById(collectivityId)
                    .orElseThrow(() -> new RuntimeException("Collectivity not found"));
            s.setCollectivity(collectivity);

            sponsorshipRepo.save(s);
        }
    }

    @Transactional
    public void setJoinDate(Member member, LocalDate date) {
        // Correction : utiliser setDateAdhesion() au lieu de setJoinDate()
        member.setDateAdhesion(date);
        memberRepo.save(member);
    }
}