package com.Vitality_Hub.Virtual_Health_Assisstant.appointment.repository;

import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
