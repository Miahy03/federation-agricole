package com.example.federation.controller;

import com.example.federation.dto.*;
import com.example.federation.service.CollectivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collectivities")
public class CollectivityController {

    private final CollectivityService service;

    public CollectivityController(CollectivityService service) {
        this.service = service;
    }

    @PostMapping
    public List<CollectivityResponse> create(@RequestBody List<CollectivityRequest> dtos) {
        return service.createAll(dtos);
    }

    @GetMapping("/{id}")
    public CollectivityResponse getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/informations")
    public CollectivityResponse updateInformations(
            @PathVariable String id,
            @RequestBody Map<String, Object> request) {

        String name = (String) request.get("name");
        Integer number = (Integer) request.get("number");

        return service.updateInformations(id, name, number);

    }
}