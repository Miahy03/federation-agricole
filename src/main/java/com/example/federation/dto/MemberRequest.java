package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberRequest {

    private String firstName;
    private String lastName;

    private String birthDate;
    private String admissionDate;

    private String gender;
    private String address;
    private String job;
    private String phone;
    private String email;

    private Long collectivityId;

    private List<Long> sponsorIds;
}