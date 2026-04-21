package com.example.federation.entity;

public class Presence {

    private Long id;
    private Long membreId;
    private boolean present;

    public Long getId() { return id; }

    public Long getMembreId() { return membreId; }

    public boolean isPresent() { return present; }

    public void setPresent(boolean present) {
        this.present = present;
    }
}