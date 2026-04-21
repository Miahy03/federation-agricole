package com.example.federation.service;

import com.example.federation.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final AttendanceRepository attendanceRepo;

    public StatsService(AttendanceRepository attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    public double attendanceRate() {

        long total = attendanceRepo.count();
        long present = attendanceRepo.countByPresentTrue();

        if (total == 0) return 0;

        return (double) present / total;
    }
}