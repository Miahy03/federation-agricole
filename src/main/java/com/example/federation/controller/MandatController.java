package com.example.federation.controller;

import com.example.federation.dto.MandatRequest;
import com.example.federation.entity.Member;
import com.example.federation.service.MandatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mandats")
public class MandatController {

    private final MandatService service;

    public MandatController(MandatService service) {
        this.service = service;
    }

    @PostMapping
    public Member create(@RequestBody MandatRequest request) {
        return service.create(request.getMember(), request.getSponsors());
    }
}