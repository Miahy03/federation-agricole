package com.example.federation.entity;
import jakarta.persistence.*;

@Entity
public class Compte{
@Id @GeneratedValue private Long id;
private String type;
private String titulaire;
private String numero;
private double solde;

@ManyToOne
private Collectivite collectivite;

public Long getId(){return id;}
public void setId(Long id){this.id=id;}
public String getType(){return type;}
public void setType(String t){this.type=t;}
public String getTitulaire(){return titulaire;}
public void setTitulaire(String t){this.titulaire=t;}
public String getNumero(){return numero;}
public void setNumero(String n){this.numero=n;}
public double getSolde(){return solde;}
public void setSolde(double s){this.solde=s;}
public Collectivite getCollectivite(){return collectivite;}
public void setCollectivite(Collectivite c){this.collectivite=c;}
}
