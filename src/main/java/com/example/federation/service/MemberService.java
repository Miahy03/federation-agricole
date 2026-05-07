package com.example.federation.service;

import com.example.federation.entity.*;
import com.example.federation.repository.*;
import com.example.federation.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepo;
    private final CollectivityRepository collectivityRepo;
    private final SponsorshipRepository sponsorshipRepo;
    private final PaymentRepository paymentRepository;

    private static final double MEMBERSHIP_FEE = 50000.0;

    public MemberService(MemberRepository memberRepo,
                         CollectivityRepository collectivityRepo,
                         SponsorshipRepository sponsorshipRepo,
                         PaymentRepository paymentRepository) {
        this.memberRepo = memberRepo;
        this.collectivityRepo = collectivityRepo;
        this.sponsorshipRepo = sponsorshipRepo;
        this.paymentRepository = paymentRepository;
    }

    public MemberResponse admitMember(MemberRequest request) {

        // 1. Vérifier collectivité
        Collectivity collectivity = collectivityRepo.findById(request.getCollectivityId())
                .orElseThrow(() -> new RuntimeException("Collectivity not found"));

        // 2. Vérifier parrains (B-2)
        List<ParrainRequest> parrains = request.getParrains();
        if (parrains == null || parrains.size() < 2) {
            throw new RuntimeException("At least 2 sponsors required (B-2 condition)");
        }

        // 3. Vérifier règle B-2
        long sponsorsFromTarget = parrains.stream()
                .filter(p -> isSponsorInCollectivity(p.getId(), request.getCollectivityId()))
                .count();
        long sponsorsFromOther = parrains.size() - sponsorsFromTarget;

        if (sponsorsFromTarget < sponsorsFromOther) {
            throw new RuntimeException("Sponsorship condition failed");
        }

        // 4. Vérifier email unique
        if (memberRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // 5. Créer membre
        Member member = new Member();
        member.setId(UUID.randomUUID().toString());
        member.setNom(request.getNom());
        member.setPrenom(request.getPrenom());
        member.setDateNaissance(request.getDateNaissance());
        member.setDateAdhesion(LocalDate.now());
        member.setGenre(request.getGenre());
        member.setAdresse(request.getAdresse());
        member.setMetier(request.getMetier());
        member.setTelephone(request.getTelephone());
        member.setEmail(request.getEmail());
        member.setPoste(request.getPoste());
        member.setCollectivity(collectivity);

        Member saved = memberRepo.save(member);

        // 6. Enregistrer les parrainages avec relation "AMI" par défaut
        for (ParrainRequest parrain : parrains) {
            Sponsorship sponsorship = new Sponsorship();
            sponsorship.setSponsor(memberRepo.findById(parrain.getId()).orElse(null));
            sponsorship.setMember(saved);
            sponsorship.setCollectivity(collectivity);
            String relation = parrain.getRelation();
            if (relation == null || relation.isEmpty()) {
                relation = "AMI";
            }
            sponsorship.setRelation(relation);
            sponsorshipRepo.save(sponsorship);
        }

        // 7. Enregistrer paiement
        Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        payment.setDate(LocalDate.now());
        payment.setAmount(MEMBERSHIP_FEE);
        payment.setMethod("CASH");
        payment.setMember(saved);
        payment.setCollectivity(collectivity);
        paymentRepository.save(payment);

        MemberResponse response = new MemberResponse();
        response.setId(saved.getId());
        response.setMessage("Member admitted successfully");
        response.setCollectivityId(collectivity.getId());
        response.setTotalPaid(MEMBERSHIP_FEE);

        return response;
    }

    private boolean isSponsorInCollectivity(String sponsorId, String collectivityId) {
        return memberRepo.findById(sponsorId)
                .map(m -> m.getCollectivity() != null && m.getCollectivity().getId().equals(collectivityId))
                .orElse(false);
    }
}