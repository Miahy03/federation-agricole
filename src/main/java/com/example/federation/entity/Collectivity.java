package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Collectivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String name;
    private String speciality;
    private LocalDate creationDate;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "collectivity")
    private List<Member> members;

    @OneToMany(mappedBy = "collectivity")
    private List<Account> accounts;
}