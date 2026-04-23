package com.example.federation.dto;

import com.example.federation.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse extends Member {
    private Long memberId;
    private Long collectivityId;
    private Double amount;
}