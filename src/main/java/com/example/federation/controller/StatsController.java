package com.example.federation.controller;

import com.example.federation.service.FederationStatsService;
import com.example.federation.service.StatsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;
    private final FederationStatsService federationService;

    public StatsController(StatsService statsService,
                           FederationStatsService federationService) {
        this.statsService = statsService;
        this.federationService = federationService;
    }

    @GetMapping("/collectivity")
    public double collectivityStats() {

        return statsService.attendanceRate();
    }

    @GetMapping("/federation")
    public Map<String, Object> federationStats() {
        return federationService.getStats();
    }
}