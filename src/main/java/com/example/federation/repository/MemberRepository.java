package com.example.federation.repository;
import com.example.federation.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MemberRepository extends JpaRepository<Member,Long>{}
