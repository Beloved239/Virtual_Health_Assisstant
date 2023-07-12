package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdjustedWeightRequest {
    private String gender;
    private Double weight;
    private Double height;

}
