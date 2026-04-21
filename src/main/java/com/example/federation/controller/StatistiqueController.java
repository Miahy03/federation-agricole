package com.example.federation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistiques")
public class StatistiqueController {

    @GetMapping("/{id}")
    public String stats(@PathVariable Long id) {
        return "Statistiques collectivité " + id;
    }
}
