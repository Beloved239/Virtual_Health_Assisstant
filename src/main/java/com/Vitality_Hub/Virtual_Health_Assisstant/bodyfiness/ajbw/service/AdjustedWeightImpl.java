package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.AdjustedBodyWeightResponse;
import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.AdjustedWeightRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.ajbw.dto.DataInfo;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.ResponseUtils;
import org.springframework.stereotype.Service;

@Service
public class AdjustedWeightImpl implements AdjustedBodyWeightService{
    @Override
    public AdjustedBodyWeightResponse checkBodyWeight(AdjustedWeightRequest adjustedWeightRequest) {

        double idealWeight =ResponseUtils.calculateIdealWeight(adjustedWeightRequest.getHeight(),adjustedWeightRequest.getWeight(),adjustedWeightRequest.getGender());

        double adjustedWeight = ResponseUtils.calculateAdjustedWeight(idealWeight,adjustedWeightRequest.getWeight());

        return AdjustedBodyWeightResponse.builder()
                .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                .dataInfo(DataInfo.builder()
                        .idealWeight(idealWeight)
                        .adjustedWeight(adjustedWeight)
                        .build())
                .build();
    }





}
