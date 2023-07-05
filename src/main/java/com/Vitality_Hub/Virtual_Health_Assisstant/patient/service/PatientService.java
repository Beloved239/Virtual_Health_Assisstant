package com.Vitality_Hub.Virtual_Health_Assisstant.patient.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.PatientRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    ResponseEntity<Response> signUp(PatientRequest patientRequest);

    ResponseEntity<Response> signIn(LoginRequest loginRequest);

    ResponseEntity<Response> resetPassword(LoginRequest loginRequest);

    List<Response> getAllPatient();

    Response getPatientByEmail(String email);
}
