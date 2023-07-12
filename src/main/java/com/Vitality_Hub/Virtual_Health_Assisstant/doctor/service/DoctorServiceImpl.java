package com.Vitality_Hub.Virtual_Health_Assisstant.doctor.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Data;
import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.doctor.dto.DoctorRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.doctor.entity.Doctors;
import com.Vitality_Hub.Virtual_Health_Assisstant.doctor.repository.DoctorRepository;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity.Patients;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.ResponseUtils;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.Roles;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Response> registerDoctor(DoctorRequest doctorRequest) {
        boolean isDoctorsExist = doctorRepository.existsByEmail(doctorRequest.getEmail());
        if (isDoctorsExist){
            return ResponseEntity.ok(Response.builder()
                            .responseCode(ResponseUtils.USER_EXISTS_CODE)
                            .responseMessage(ResponseUtils.USER_EXISTS_MESSAGE)
                            .data(null)
                    .build());
        }else {
            Doctors newDoctors = Doctors.builder()
                    .name(doctorRequest.getName())
                    .email(doctorRequest.getEmail())
                    .dateOfBirth(doctorRequest.getDateOfBirth())
                    .password(passwordEncoder.encode(doctorRequest.getPassword()))
                    .gender(doctorRequest.getGender())
                    .specialization(doctorRequest.getSpecialization())
                    .phoneNumber(doctorRequest.getPhoneNumber())
                    .build();
            doctorRepository.save(newDoctors);
           return ResponseEntity.ok(Response.builder()
                            .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                            .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                            .data(Data.builder()
                                    .email(doctorRequest.getEmail())
                                    .name(doctorRequest.getName())
                                    .description("Welcome to Vitality Hub!")
                                    .build())
                    .build());
        }
    }

    @Override
    public ResponseEntity<Response> signIn(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new  ResponseEntity<>(
                Response.builder()
                        .responseCode(ResponseUtils.SUCCESSFUL_LOGIN_RESPONSE_CODE)
                        .responseMessage(ResponseUtils.SUCCESSFUL_LOGIN_MESSAGE)
                        .data(Data.builder()
                                .name(null)
                                .email(null)
                                .description(null)
                                .build())
                        .build(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> findByUsername(String username) {
        boolean isExistsByEmail= doctorRepository.existsByEmail(username);

        if (!isExistsByEmail){
            return ResponseEntity.ok(Response.builder()
                    .responseCode(ResponseUtils.USER_NOT_FOUND_CODE)
                    .responseMessage(ResponseUtils.USER_NOT_FOUND_MESSAGE)
                    .data(null)
                    .build());
        }else {
            Doctors doctors = doctorRepository.findByEmail(username);
            return ResponseEntity.ok(Response.builder()
                    .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                    .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                    .data(Data.builder()
                            .name(doctors.getName())
                            .email(doctors.getEmail())
                            .description(Roles.DOCTOR.toString())
                            .build())
                    .build());
        }

    }

    @Override
    public ResponseEntity<Response> resetPassword(LoginRequest loginRequest) {
        boolean existsByEmail = doctorRepository.existsByEmail(loginRequest.getEmail());
        Doctors doctor = doctorRepository.findByEmail(loginRequest.getEmail());

        if (!existsByEmail){
            return ResponseEntity.ok(Response.builder()
                    .responseCode(ResponseUtils.UNSUCCESSFUL_LOGIN_RESPONSE_CODE)
                    .responseMessage(ResponseUtils.EMAIL_DOES_NOT_EXIST_MESSAGE)
                    .data(null)
                    .build());
        }else {
            String encoder = passwordEncoder.encode(loginRequest.getPassword());
            doctor.setPassword(encoder);
            doctorRepository.save(doctor);

            return ResponseEntity.ok(Response.builder()
                    .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                    .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                    .data(null)
                    .build());
        }
    }
}
