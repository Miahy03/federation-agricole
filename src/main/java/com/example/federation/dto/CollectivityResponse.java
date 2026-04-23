package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CollectivityResponse {
    private MemberResponse member;
    private List<SponsorshipResponse> sponsors;
}