package com.Vitality_Hub.Virtual_Health_Assisstant.doctor.repository;

import com.Vitality_Hub.Virtual_Health_Assisstant.doctor.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {

}
