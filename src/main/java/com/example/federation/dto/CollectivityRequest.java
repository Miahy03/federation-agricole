package com.example.federation.dto;

import java.util.List;

public class CollectivityRequest {

    private String localite;
    private String specialite;
    private List<MemberRequest> membres;

    public String getLocalite() { return localite; }
    public void setLocalite(String localite) { this.localite = localite; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public List<MemberRequest> getMembres() { return membres; }
    public void setMembres(List<MemberRequest> membres) { this.membres = membres; }
}