package com.example.federation.dto;

import java.time.LocalDate;
import java.util.List;

public class MemberRequest {

    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private LocalDate dateAdhesion;
    private String genre;
    private String adresse;
    private String metier;
    private String telephone;
    private String email;
    private String poste;
    private List<ParrainRequest> parrains;

    // GETTERS / SETTERS
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public LocalDate getDateAdhesion() { return dateAdhesion; }
    public void setDateAdhesion(LocalDate dateAdhesion) { this.dateAdhesion = dateAdhesion; }

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

    public List<ParrainRequest> getParrains() { return parrains; }
    public void setParrains(List<ParrainRequest> parrains) { this.parrains = parrains; }
}