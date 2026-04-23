package com.example.federation.controller;

import com.example.federation.dto.AdhesionRequest;
import com.example.federation.entity.Member;
import com.example.federation.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member createMember(@RequestBody AdhesionRequest request) {
        return memberService.createMember(request);
    }
}