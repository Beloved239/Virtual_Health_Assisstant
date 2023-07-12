package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataInfo {
    private Double idealWeight;
    private Double adjustedWeight;
}
