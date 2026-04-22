package com.example.federation.service;

import com.example.federation.entity.Member;
import com.example.federation.entity.Sponsorship;
import com.example.federation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public Member create(Member m, List<Sponsorship> sponsors) {

        if (sponsors == null || sponsors.size() < 2) {
            throw new RuntimeException("At least 2 sponsors required");
        }

        if (m.getCollectivity() == null) {
            throw new RuntimeException("Collectivity required");
        }

        m.setJoinDate(LocalDate.now());

        return repo.save(m);
    }
}