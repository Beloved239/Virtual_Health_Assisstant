package com.Vitality_Hub.Virtual_Health_Assisstant.admin.controller;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.admin.service.AdminService;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.PatientRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/signup")
    ResponseEntity<Response> signup(@RequestBody PatientRequest patientRequest){
        return adminService.adminSignUp(patientRequest);
    }

    @PostMapping("/signin")
    ResponseEntity<Response> signin(@RequestBody LoginRequest loginRequest){
        return adminService.signIn(loginRequest);
    }


}
