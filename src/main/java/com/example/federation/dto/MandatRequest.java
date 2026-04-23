package com.example.federation.dto;

import java.util.List;

public class MandatRequest {
    private String memberId;
    private String collectivityId;
    private List<SponsorshipRequest> sponsors;

    // Getters et Setters
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getCollectivityId() { return collectivityId; }
    public void setCollectivityId(String collectivityId) { this.collectivityId = collectivityId; }

    public List<SponsorshipRequest> getSponsors() { return sponsors; }
    public void setSponsors(List<SponsorshipRequest> sponsors) { this.sponsors = sponsors; }
}