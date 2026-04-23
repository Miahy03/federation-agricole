package com.example.federation.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sponsorships")
public class Sponsorship {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private Member sponsor;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;

    private String relation;
    private LocalDateTime createdAt;

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Member getSponsor() { return sponsor; }
    public void setSponsor(Member sponsor) { this.sponsor = sponsor; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    public Collectivity getCollectivity() { return collectivity; }
    public void setCollectivity(Collectivity collectivity) { this.collectivity = collectivity; }

    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}