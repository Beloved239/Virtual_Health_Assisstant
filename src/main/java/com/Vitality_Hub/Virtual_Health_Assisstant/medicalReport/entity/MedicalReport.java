package com.Vitality_Hub.Virtual_Health_Assisstant.medicalReport.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medical_report")
@Builder
public class MedicalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorName;
    private List<String> reportDetails;
    private String diagnosis;

}
