package com.example.federation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
public class Sponsorship {

    @Id
    @GeneratedValue
    private Long id;

    private Long sponsorId;
    private String relationship;
}