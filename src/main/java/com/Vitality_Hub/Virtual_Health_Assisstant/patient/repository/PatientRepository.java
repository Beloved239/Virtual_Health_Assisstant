package com.Vitality_Hub.Virtual_Health_Assisstant.patient.repository;

import com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patients, Long> {

    Optional<Patients> findByEmail(String email);
    boolean existsByEmail(String email);
}
