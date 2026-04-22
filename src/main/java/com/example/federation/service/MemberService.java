package com.example.federation.service;

import com.example.federation.dto.MemberRequest;
import com.example.federation.entity.Member;
import com.example.federation.exceptions.BadRequestException;
import com.example.federation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {

    private final MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public Member create(MemberRequest r) {

        if (r.getFirstName() == null || r.getLastName() == null) {
            throw new BadRequestException("Name required");
        }

        Member m = new Member();
        m.setFirstName(r.getFirstName());
        m.setLastName(r.getLastName());
        m.setBirthDate(r.getBirthDate());
        m.setGender(r.getGender());
        m.setJoinDate(LocalDate.now());

        return repo.save(m);
    }
}