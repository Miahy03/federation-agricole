package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sponsorship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String relationship;

    // candidat (le membre créé)
    @ManyToOne
    @JoinColumn(name = "id_candidate")
    private Member candidate;

    // sponsor
    @ManyToOne
    @JoinColumn(name = "id_sponsor")
    private Member sponsor;

    @ManyToOne
    @JoinColumn(name = "id_collectivity")
    private Collectivity collectivity;
}