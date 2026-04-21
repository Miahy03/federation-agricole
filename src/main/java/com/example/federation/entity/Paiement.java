package com.example.federation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Paiement {

    @Id
    @GeneratedValue
    private Long id;

    private double montant;
    private String mode;
    private LocalDate date;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private Compte compte;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Membre getMembre() { return membre; }
    public void setMembre(Membre membre) { this.membre = membre; }

    public Compte getCompte() { return compte; }
    public void setCompte(Compte compte) { this.compte = compte; }
}