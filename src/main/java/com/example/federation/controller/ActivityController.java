package com.example.federation.controller;

import com.example.federation.entity.Activity;
import com.example.federation.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }


    @PostMapping
    public Activity create(@RequestBody Activity activity) {
        return service.create(activity);
    }

    @GetMapping
    public List<Activity> getAll() {
        return service.getAll();
    }
}