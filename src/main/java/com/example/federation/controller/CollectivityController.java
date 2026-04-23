package com.example.federation.controller;

import com.example.federation.entity.Account;
import com.example.federation.entity.Collectivity;
import com.example.federation.service.CollectivityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/collectivities")
public class CollectivityController {

    private final CollectivityService service;

    public CollectivityController(CollectivityService service) {
        this.service = service;
    }

    @PostMapping
    public Collectivity create(@RequestBody Collectivity c) {
        return service.create(c);
    }

    @GetMapping("/{id}")
    public Collectivity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/{id}/financialAccounts")
    public List<Account> getAccounts(
            @PathVariable Long id,
            @RequestParam(required = false) String at
    ) {
        LocalDate date = (at != null) ? LocalDate.parse(at) : null;
        return service.getAccounts(id, date);
    }
}