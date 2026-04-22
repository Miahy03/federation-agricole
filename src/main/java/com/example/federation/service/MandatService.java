package com.example.federation.service;

import com.example.federation.entity.Member;
import com.example.federation.entity.Sponsorship;
import com.example.federation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MandatService {

    private final MemberRepository repo;

    public MandatService(MemberRepository repo) {
        this.repo = repo;
    }

    public Member create(Member m, List<Sponsorship> sponsors) {

        if (sponsors == null || sponsors.size() < 2) {
            throw new RuntimeException("At least 2 sponsors required");
        }

        if (m.getCollectivity() == null) {
            throw new RuntimeException("Collectivity required");
        }

        long sameCollectivity = sponsors.stream()
                .filter(s -> s.getSponsor().getCollectivity().getId()
                        .equals(m.getCollectivity().getId()))
                .count();

        long others = sponsors.size() - sameCollectivity;

        if (sameCollectivity < others) {
            throw new RuntimeException("Invalid sponsors distribution");
        }

        m.setJoinDate(LocalDate.now());

        return repo.save(m);
    }
}