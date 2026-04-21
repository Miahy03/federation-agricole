package com.example.federation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;
    private String type;
    private String method;
    private LocalDate date;
}