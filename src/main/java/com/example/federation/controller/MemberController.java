package com.example.federation.controller;

import com.example.federation.dto.AccountResponse;
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

    @PostMapping
    public Member create(@RequestBody AccountResponse r) {
        return service.create(r);
    }
}