package com.example.federation.controller;

import com.example.federation.dto.MandatRequest;
import com.example.federation.service.MandatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mandats")
public class MandatController {

    private final MandatService mandatService;

    public MandatController(MandatService mandatService) {
        this.mandatService = mandatService;
    }

    @PostMapping
    public String createMandat(@RequestBody MandatRequest request) {
        mandatService.validateSponsors(
                request.getMemberId(),
                request.getSponsors(),
                request.getCollectivityId()
        );
        return "Mandat créé avec succès";
    }
}