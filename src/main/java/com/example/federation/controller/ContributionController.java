package com.example.federation.controller;

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

    @PostMapping("/{memberId}/{collectivityId}")
    public Contribution create(@PathVariable Long memberId,
                               @PathVariable Long collectivityId,
                               @RequestBody double amount) {
        return service.create(memberId, collectivityId, amount);
    }
}