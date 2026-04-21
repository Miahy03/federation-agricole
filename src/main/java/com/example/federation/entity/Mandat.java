package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Mandat {

    @Id
    @GeneratedValue
    private Long id;

    private String poste; // PRESIDENT, TREASURER, SECRETARY

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Collectivity collectivity;
}