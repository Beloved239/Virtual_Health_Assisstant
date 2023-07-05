package com.Vitality_Hub.Virtual_Health_Assisstant.doctor.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.doctor.dto.DoctorRequest;
import org.springframework.http.ResponseEntity;

public interface DoctorService {
    ResponseEntity<Response> registerDoctor(DoctorRequest doctorRequest);

    ResponseEntity<Response> signIn(LoginRequest loginRequest);

    ResponseEntity<Response> findByUsername(String username);

    ResponseEntity<Response> resetPassword(LoginRequest loginRequest);



}
