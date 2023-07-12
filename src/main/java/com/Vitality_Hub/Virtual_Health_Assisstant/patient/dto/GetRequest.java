package com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRequest {
    @JsonIgnore
    private String email;
}
