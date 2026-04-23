package com.example.federation.dto;

public class SponsorshipRequest {
    private String sponsorId;    // ou "id"
    private String relationship; // ou "relation"

    // Getters et Setters
    public String getSponsorId() { return sponsorId; }
    public void setSponsorId(String sponsorId) { this.sponsorId = sponsorId; }

    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }
}