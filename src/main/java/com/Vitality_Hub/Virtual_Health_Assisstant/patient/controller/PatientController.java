package com.Vitality_Hub.Virtual_Health_Assisstant.patient.controller;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.GetRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.PatientRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }



    @GetMapping("/getall")
    public List<Response> getAllPatients(){
        return patientService.getAllPatient();
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> registerPatient(@RequestBody PatientRequest patientRequest){
        return patientService.signUp(patientRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> loginUsers(@RequestBody LoginRequest loginRequest){
        return patientService.signIn(loginRequest);
    }

    @PutMapping("/resetpassword")
    public ResponseEntity<Response> resetPassword(@RequestBody LoginRequest loginRequest){
        return patientService.resetPassword(loginRequest);
    }

    @GetMapping("/getuser")
    public ResponseEntity<Response> getPatientByUsername(@RequestBody GetRequest getRequest){
        return ResponseEntity.ok(patientService.getPatientByEmail(getRequest.getEmail()));
    }

}
