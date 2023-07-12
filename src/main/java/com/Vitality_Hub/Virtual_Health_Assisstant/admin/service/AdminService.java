package com.Vitality_Hub.Virtual_Health_Assisstant.admin.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.PatientRequest;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<Response> adminSignUp(PatientRequest patientRequest);

    ResponseEntity<Response> signIn(LoginRequest loginRequest);
}
