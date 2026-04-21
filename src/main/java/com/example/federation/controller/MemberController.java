package com.example.federation.controller;

import com.example.federation.entity.Member;
import com.example.federation.entity.Sponsorship;
import com.example.federation.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public Member create(@RequestBody Member m,
                         @RequestBody List<Sponsorship> sponsors) {
        return service.create(m, sponsors);
    }
}