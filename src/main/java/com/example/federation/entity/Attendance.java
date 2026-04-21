package com.example.federation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Attendance {

    @Id
    @GeneratedValue
    private Long id;

    private boolean present;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Activity activity;
}