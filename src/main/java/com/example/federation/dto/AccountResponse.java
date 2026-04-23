package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountResponse {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate admissionDate;
    private String gender;
    private String address;
    private String job;
    private String phone;
    private String email;
}