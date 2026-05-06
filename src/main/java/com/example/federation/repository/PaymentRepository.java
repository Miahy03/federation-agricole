package com.example.federation.repository;

import com.example.federation.entity.Member;
import com.example.federation.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    List<Payment> findByMemberAndDateBetween(Member member, LocalDate startDate, LocalDate endDate);

    @Query("SELECT p FROM Payment p WHERE p.member = :member AND p.date BETWEEN :startDate AND :endDate")
    List<Payment> findPaymentsByMemberAndDateRange(
            @Param("member") Member member,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<Payment> findByCollectivityIdAndDateBetween(String collectivityId, LocalDate startDate, LocalDate endDate);


    List<Payment> findByDateBetween(LocalDate startDate, LocalDate endDate);
}