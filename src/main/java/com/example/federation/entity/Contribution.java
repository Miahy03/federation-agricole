package com.example.federation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contributions")
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;

    private double amount;
    private LocalDate dueDate;
    private PaymentStatus status;

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    public Collectivity getCollectivity() { return collectivity; }
    public void setCollectivity(Collectivity collectivity) { this.collectivity = collectivity; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}