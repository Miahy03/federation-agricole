package com.example.federation.service;

import com.example.federation.repository.AttendanceRepository;
import com.example.federation.repository.CollectivityRepository;
import com.example.federation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FederationStatsService {

    private final MemberRepository memberRepo;
    private final CollectivityRepository collectivityRepo;
    private final AttendanceRepository attendanceRepo;

    public FederationStatsService(MemberRepository memberRepo,
                                  CollectivityRepository collectivityRepo,
                                  AttendanceRepository attendanceRepo) {
        this.memberRepo = memberRepo;
        this.collectivityRepo = collectivityRepo;
        this.attendanceRepo = attendanceRepo;
    }

    public Map<String, Object> getStats() {

        Map<String, Object> stats = new HashMap<>();

        long members = memberRepo.count();
        long collectivities = collectivityRepo.count();

        long totalAttendance = attendanceRepo.count();
        long present = attendanceRepo.countByPresentTrue();

        double rate = totalAttendance == 0 ? 0 :
                (double) present / totalAttendance;

        stats.put("members", members);
        stats.put("collectivities", collectivities);
        stats.put("attendanceRate", rate);

        return stats;
    }
}