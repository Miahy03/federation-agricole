package com.example.federation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

    private String address;
    private String job;
    private String phone;
    private String email;

    private LocalDate joinDate;

    @ManyToOne
    private Collectivity collectivity;
}