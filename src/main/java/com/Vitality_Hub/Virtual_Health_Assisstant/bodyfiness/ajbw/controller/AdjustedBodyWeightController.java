package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.controller;

import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.AdjustedBodyWeightResponse;
import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.AdjustedWeightRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.service.AdjustedBodyWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weight")
public class AdjustedBodyWeightController {
    @Autowired
    AdjustedBodyWeightService adjustedBodyWeightService;
    @PostMapping
    private ResponseEntity<AdjustedBodyWeightResponse> checkBodyWeight(@RequestBody AdjustedWeightRequest adjustedWeightRequest){
        return ResponseEntity.ok(adjustedBodyWeightService.checkBodyWeight(adjustedWeightRequest));
    }
}
