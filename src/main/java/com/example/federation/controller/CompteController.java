package com.example.federation.controller;

import com.example.federation.entity.Compte;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    @PostMapping
    public String create(@RequestBody Compte c) {
        return "Compte créé type : " + c.getType();
    }

    @GetMapping
    public String all() {
        return "Liste comptes";
    }
}
