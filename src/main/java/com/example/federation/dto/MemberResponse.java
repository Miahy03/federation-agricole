package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {
    private Long memberId;
    private Long collectivityId;
    private Double amount;
}