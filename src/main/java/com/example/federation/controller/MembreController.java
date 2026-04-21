package com.example.federation.controller;

import com.example.federation.entity.Membre;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membres")
public class MembreController {

    @PostMapping
    public String create(@RequestBody Membre m) {
        return "Membre ajouté : " + m.getNom();
    }

    @GetMapping
    public String all() {
        return "Liste membres";
    }
}

