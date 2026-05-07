package com.example.federation.dto;

public class MemberResponse {
    private String id;
    private String message;
    private String collectivityId;
    private double totalPaid;
    private double membershipFee;
    private double annualContributions;
    private String role;

    // Getters
    public String getId() { return id; }
    public String getMessage() { return message; }
    public String getCollectivityId() { return collectivityId; }
    public double getTotalPaid() { return totalPaid; }
    public double getMembershipFee() { return membershipFee; }
    public double getAnnualContributions() { return annualContributions; }
    public String getRole() { return role; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setCollectivityId(String collectivityId) { this.collectivityId = collectivityId; }
    public void setTotalPaid(double totalPaid) { this.totalPaid = totalPaid; }
    public void setMembershipFee(double membershipFee) { this.membershipFee = membershipFee; }
    public void setAnnualContributions(double annualContributions) { this.annualContributions = annualContributions; }
    public void setRole(String role) { this.role = role; }
}