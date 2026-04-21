package com.example.federation.controller;

import com.example.federation.entity.Mandat;
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
    public Mandat create(@RequestBody Mandat m) {
        return service.creerMandat(m);
    }
}