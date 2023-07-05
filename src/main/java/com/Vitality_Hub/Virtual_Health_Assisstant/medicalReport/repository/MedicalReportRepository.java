package com.Vitality_Hub.Virtual_Health_Assisstant.medicalReport.repository;

import com.Vitality_Hub.Virtual_Health_Assisstant.medicalReport.entity.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {

}
