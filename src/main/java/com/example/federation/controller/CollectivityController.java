package com.example.federation.controller;

import com.example.federation.dto.*;
import com.example.federation.service.CollectivityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collectivities")
public class CollectivityController {

    private final CollectivityService service;

    public CollectivityController(CollectivityService service) {
        this.service = service;
    }

    @PostMapping
    public CollectivityResponse create(@RequestBody CollectivityRequest dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CollectivityResponse getById(@PathVariable String id) {
        return service.getById(id);
    }
}