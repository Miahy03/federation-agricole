package com.example.federation.controller;

import com.example.federation.service.ContributionService;
import com.example.federation.entity.Contribution;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    private final ContributionService contributionService;

    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping("/{memberId}/{collectivityId}")
    public Contribution createContribution(
            @PathVariable String memberId,
            @PathVariable String collectivityId,
            @RequestParam double amount) {
        return contributionService.create(memberId, collectivityId, amount);
    }
}