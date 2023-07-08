package com.Vitality_Hub.Virtual_Health_Assisstant.patient.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Data;
import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.LoginRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.email.dto.EmailDetails;
import com.Vitality_Hub.Virtual_Health_Assisstant.email.service.EmailService;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.dto.PatientRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity.Patients;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.repository.PatientRepository;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.ResponseUtils;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.Roles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;

    public PatientServiceImpl(PatientRepository patientRepository, EmailService emailService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<Response> signUp(PatientRequest patientRequest) {
        boolean isEmailExist = patientRepository.existsByEmail(patientRequest.getEmail());
        if (isEmailExist) {
            return ResponseEntity.ok(Response.builder()
                    .responseCode(ResponseUtils.USER_EXISTS_CODE)
                    .responseMessage(ResponseUtils.USER_EXISTS_MESSAGE)
                    .data(null)
                    .build());
        }

        Patients patient = Patients.builder()
                .email(patientRequest.getEmail())
                .age(patientRequest.getAge())
                .firstName(patientRequest.getFirstName())
                .lastName(patientRequest.getLastName())
                .gender(patientRequest.getGender())
                .password(passwordEncoder.encode(patientRequest.getPassword()))
                .role(Roles.USER)
                .build();

        Patients savedPatient = patientRepository.save(patient);

        String name = savedPatient.getFirstName()+" "+savedPatient.getLastName();

        EmailDetails message = EmailDetails.builder()
                .recipient(savedPatient.getEmail())
                .subject("Account Created Successfully")
                .messageBody("You're Welcome to VitalityHub your username is "+savedPatient.getEmail())
                .build();
        emailService.sendSimpleEmail(message);

        return ResponseEntity.ok(Response.builder()
                        .responseCode(ResponseUtils.USER_CREATED_MESSAGE)
                        .responseMessage(ResponseUtils.USER_CREATED_MESSAGE)
                        .data(Data.builder()
                                .name(name)
                                .email(savedPatient.getEmail())
                                .description("User Created Successfully")
                                .build())
                .build());
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
    public ResponseEntity<Response> resetPassword(LoginRequest loginRequest) {

        boolean existsByEmail = patientRepository.existsByEmail(loginRequest.getEmail());
        Patients patients = patientRepository.findByEmail(loginRequest.getEmail()).get();

        if (!existsByEmail){
            return ResponseEntity.ok(Response.builder()
                    .responseCode(ResponseUtils.UNSUCCESSFUL_LOGIN_RESPONSE_CODE)
                    .responseMessage(ResponseUtils.EMAIL_DOES_NOT_EXIST_MESSAGE)
                    .data(null)
                    .build());
        }else {
            String encoder = passwordEncoder.encode(loginRequest.getPassword());
            patients.setPassword(encoder);
            patientRepository.save(patients);

            return ResponseEntity.ok(Response.builder()
                            .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                            .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                            .data(null)
                    .build());
        }
    }

    @Override
    public List<Response> getAllPatient() {
        List<Patients> patientsList = patientRepository.findAll();
        List<Response> responses = new ArrayList<>();

        for (Patients patients: patientsList){
            responses.add(Response.builder()
                    .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                    .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                            .data(Data.builder()
                                    .name(patients.getFirstName()+" "+ patients.getLastName())
                                    .email(patients.getEmail())
                                    .description(patients.getRole().toString())
                                    .build())
                    .build());
        }
        return responses;
    }

    @Override
    public Response getPatientByEmail(String email) {
        boolean isExistsByEmail= patientRepository.existsByEmail(email);

        if (!isExistsByEmail){
            return Response.builder()
                    .responseCode(ResponseUtils.USER_NOT_FOUND_CODE)
                    .responseMessage(ResponseUtils.USER_NOT_FOUND_MESSAGE)
                    .data(null)
                    .build();
        }else {
        Patients patients = patientRepository.findByEmail(email).get();
        return Response.builder()
                .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                .data(Data.builder()
                        .name(patients.getFirstName()+" "+ patients.getLastName())
                        .email(patients.getEmail())
                        .description(patients.getRole().toString())
                        .build())
                .build();
    }
    }
}
