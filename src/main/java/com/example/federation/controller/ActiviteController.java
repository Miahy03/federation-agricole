package com.example.federation.controller;
import com.example.federation.entity.Activite;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activites")
public class ActiviteController {

    @PostMapping
    public String create(@RequestBody Activite a) {
        return "Activité créée : " + a.getType();
    }

    @GetMapping
    public String all() {
        return "Liste activités";
    }
}
