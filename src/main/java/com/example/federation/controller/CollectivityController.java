package com.example.federation.controller;

import com.example.federation.entity.Collectivity;
import com.example.federation.service.CollectivityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collectivities")
public class CollectivityController {

    private final CollectivityService service;

    public CollectivityController(CollectivityService service) {
        this.service = service;
    }

    @PostMapping
    public Collectivity create(@RequestBody Collectivity c) {
        return service.create(c);
    }
}