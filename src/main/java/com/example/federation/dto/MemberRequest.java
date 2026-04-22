package com.example.federation.dto;

import com.example.federation.entity.Member;
import com.example.federation.entity.Sponsorship;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberRequest {
    private Member member;
    private List<Sponsorship> sponsors;
}