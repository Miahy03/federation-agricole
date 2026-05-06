package com.example.federation.dto;

import java.time.LocalDate;
import java.util.List;

public class CollectivityResponse {
    private String id;
    private String numero;
    private String nom;
    private String localite;
    private String specialite;
    private LocalDate dateCreation;
    private String statut;
    private List<MemberSummary> membres;

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getLocalite() { return localite; }
    public void setLocalite(String localite) { this.localite = localite; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public List<MemberSummary> getMembres() { return membres; }
    public void setMembres(List<MemberSummary> membres) { this.membres = membres; }
}