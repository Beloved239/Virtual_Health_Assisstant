package com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String gender;
    private String password;
}
