package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "collectivity")
@Getter
@Setter
public class Collectivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String name;

    private String speciality;

    @Column(name = "creation_datetime")
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;
}