package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate birthDate;
    private LocalDate joinDate;

    private String gender;
    private String phone;
    private String address;
    private String job;
    private String email;

    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;
}