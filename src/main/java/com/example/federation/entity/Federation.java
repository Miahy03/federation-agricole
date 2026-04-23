package com.example.federation.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "federations")
public class Federation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "federation", cascade = CascadeType.ALL)
    private List<Collectivity> collectivities = new ArrayList<>();

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Collectivity> getCollectivities() { return collectivities; }
    public void setCollectivities(List<Collectivity> collectivities) { this.collectivities = collectivities; }
}