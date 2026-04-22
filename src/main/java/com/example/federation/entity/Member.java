package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "join_date")
    private LocalDate joinDate;

    private String gender;
    private String address;
    private String job;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;
}