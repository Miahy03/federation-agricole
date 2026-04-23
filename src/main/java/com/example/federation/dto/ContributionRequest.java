package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContributionRequest {

    private Long memberId;
    private Long collectivityId;
    private double amount;
}