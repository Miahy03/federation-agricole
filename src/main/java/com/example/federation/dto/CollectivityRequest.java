package com.example.federation.dto;

import java.util.List;

public class CollectivityRequest {
    private String localite;
    private String specialite;
    private List<MemberInput> membres;

    // Getters et Setters
    public String getLocalite() { return localite; }
    public void setLocalite(String localite) { this.localite = localite; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public List<MemberInput> getMembres() { return membres; }
    public void setMembres(List<MemberInput> membres) { this.membres = membres; }
}