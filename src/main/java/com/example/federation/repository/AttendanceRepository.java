package com.example.federation.repository;

import com.example.federation.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    long countByPresentTrue();
}