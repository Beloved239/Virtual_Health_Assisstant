package com.Vitality_Hub.Virtual_Health_Assisstant.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private String name;
    private String email;
    private String gender;
    private String password;
    private String phoneNumber;
    private String dateOfBirth;
    private String specialization;
}
