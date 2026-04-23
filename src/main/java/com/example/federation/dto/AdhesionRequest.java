package com.example.federation.dto;

import java.time.LocalDate;

public class AdhesionRequest {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private LocalDate dateAdhesion;  // ← Ajouter ce champ
    private String genre;
    private String adresse;
    private String metier;
    private String telephone;
    private String email;
    private String poste;

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public LocalDate getDateAdhesion() { return dateAdhesion; }  // ← Ajouter getter
    public void setDateAdhesion(LocalDate dateAdhesion) { this.dateAdhesion = dateAdhesion; }  // ← Ajouter setter

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getMetier() { return metier; }
    public void setMetier(String metier) { this.metier = metier; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
}