package com.example.federation.controller;

import com.example.federation.dto.MemberRequest;
import com.example.federation.entity.Member;
import com.example.federation.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json")
    public Member create(@RequestBody MemberRequest request) {
        return service.create(request.getMember(), request.getSponsors());
    }
}