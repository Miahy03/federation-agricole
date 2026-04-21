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

    private String firstName;
    private String lastName;

    private String gender;
    private String job;
    private String phone;

    private LocalDate joinDate;

    @ManyToOne
    private Collectivity collectivity;
}