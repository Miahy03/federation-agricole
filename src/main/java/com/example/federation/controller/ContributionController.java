package com.example.federation.controller;

import com.example.federation.dto.ContributionRequest;
import com.example.federation.entity.Contribution;
import com.example.federation.service.ContributionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contributions")
public class ContributionController {

    private final ContributionService service;

    public ContributionController(ContributionService service) {
        this.service = service;
    }

    @PostMapping
    public Contribution create(@RequestBody ContributionRequest request) {
        return service.create(
                request.getMemberId(),
                request.getCollectivityId(),
                request.getAmount()
        );
    }
}