package com.example.federation.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {

    @PostMapping
    public String createMember(@RequestBody String body) {
        System.out.println("JSON reçu: " + body);
        return "Reçu: " + body;
    }
}