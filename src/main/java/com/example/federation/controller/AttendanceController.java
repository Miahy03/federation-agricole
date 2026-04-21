package com.example.federation.controller;

import com.example.federation.entity.Attendance;
import com.example.federation.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }
    @PostMapping
    public Attendance mark(@RequestBody Attendance attendance) {
        return service.mark(attendance);
    }


    @GetMapping
    public List<Attendance> getAll() {
        return service.getAll();
    }
}