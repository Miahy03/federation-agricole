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
public class Collectivity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private String specialty;
    private LocalDate creationDate;
}