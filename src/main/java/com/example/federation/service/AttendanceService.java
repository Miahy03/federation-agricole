package com.example.federation.service;

import com.example.federation.entity.Attendance;
import com.example.federation.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository repo;

    public AttendanceService(AttendanceRepository repo) {
        this.repo = repo;
    }

    public Attendance mark(Attendance attendance) {
        return repo.save(attendance);
    }

    public List<Attendance> getAll() {
        return repo.findAll();
    }
}