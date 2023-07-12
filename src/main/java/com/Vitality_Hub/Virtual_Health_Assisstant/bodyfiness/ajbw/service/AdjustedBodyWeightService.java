package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.AdjustedBodyWeightResponse;
import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.AdjustedWeightRequest;
import org.springframework.stereotype.Service;

@Service
public interface AdjustedBodyWeightService {
    AdjustedBodyWeightResponse checkBodyWeight(AdjustedWeightRequest adjustedWeightRequest);
}
