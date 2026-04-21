package com.example.federation.entity;
import jakarta.persistence.*;

@Entity
public class Membre{
@Id @GeneratedValue private Long id;
private String nom;
private String prenom;
private String email;

@ManyToOne
private Collectivite collectivite;

public Long getId(){return id;}
public void setId(Long id){this.id=id;}
public String getNom(){return nom;}
public void setNom(String n){this.nom=n;}
public String getPrenom(){return prenom;}
public void setPrenom(String p){this.prenom=p;}
public String getEmail(){return email;}
public void setEmail(String e){this.email=e;}
public Collectivite getCollectivite(){return collectivite;}
public void setCollectivite(Collectivite c){this.collectivite=c;}
}
