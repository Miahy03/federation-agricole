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

    @ManyToOne
    @JoinColumn(name = "id_candidate")
    private Member candidate;

    @ManyToOne
    @JoinColumn(name = "id_sponsor")
    private Member sponsor;

    @ManyToOne
    @JoinColumn(name = "id_collectivity")
    private Collectivity collectivity;
}