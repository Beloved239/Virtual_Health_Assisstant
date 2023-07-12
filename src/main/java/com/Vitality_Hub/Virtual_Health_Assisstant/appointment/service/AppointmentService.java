package com.Vitality_Hub.Virtual_Health_Assisstant.appointment.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.dto.AppointmentRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.PatientRequest;
import org.springframework.http.ResponseEntity;

public interface AppointmentService {

    ResponseEntity<Response> bookAppointment(AppointmentRequest appointmentRequest);
}
