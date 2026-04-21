package com.example.federation.controller;

import com.example.federation.entity.Presence;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presences")
public class PresenceController {

    @PostMapping
    public String create(@RequestBody Presence p) {
        return "Présence enregistrée membre " + p.getMembreId();
    }

    @GetMapping
    public String all() {
        return "Liste présences";
    }
}