package com.example.federation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Mandat {

    @Id
    @GeneratedValue
    private Long id;

    private String poste; // PRESIDENT, SECRETAIRE, TRESORIER

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private Collectivite collectivite;

    // getters / setters
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }

    public Membre getMembre() { return membre; }
    public void setMembre(Membre membre) { this.membre = membre; }

    public Collectivite getCollectivite() { return collectivite; }
    public void setCollectivite(Collectivite collectivite) { this.collectivite = collectivite; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
}