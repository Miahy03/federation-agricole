package com.example.federation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate date;
    private double amount;
    private String method;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;

    // Constructeurs
    public Payment() {}

    public Payment(LocalDate date, double amount, String method, Member member, Collectivity collectivity) {
        this.date = date;
        this.amount = amount;
        this.method = method;
        this.member = member;
        this.collectivity = collectivity;
    }

    // Getters
    public String getId() { return id; }
    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public Member getMember() { return member; }
    public Collectivity getCollectivity() { return collectivity; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setMethod(String method) { this.method = method; }
    public void setMember(Member member) { this.member = member; }
    public void setCollectivity(Collectivity collectivity) { this.collectivity = collectivity; }
}