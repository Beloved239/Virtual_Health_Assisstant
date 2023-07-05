package com.Vitality_Hub.Virtual_Health_Assisstant.medicalReport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedReportRequest {
    private String doctorName;
    private String reportDetails;
    private String diagnosis;
}
