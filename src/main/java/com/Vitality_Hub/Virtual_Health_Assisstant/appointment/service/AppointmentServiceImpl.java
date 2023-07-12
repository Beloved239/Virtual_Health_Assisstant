package com.Vitality_Hub.Virtual_Health_Assisstant.appointment.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Data;
import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.dto.AppointmentRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.entity.Appointment;
import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.repository.AppointmentRepository;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity.Patients;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.repository.PatientRepository;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

//    private final PatientRepository patientRepository;
    private final PatientRepository repository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(PatientRepository repository, AppointmentRepository appointmentRepository) {
        this.repository = repository;

        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ResponseEntity<Response> bookAppointment(AppointmentRequest appointmentRequest) {
        boolean existsByEmail = repository.existsByEmail(appointmentRequest.getEmail());
        Patients patients = repository.findByEmail(appointmentRequest.getEmail()).get();

        if (existsByEmail){
            Appointment appointment = Appointment.builder()

                    .appointmentDate(appointmentRequest.getAppointmentDate())
                    .status("true")
                    .notes(appointmentRequest.getNotes())
                    .status(appointmentRequest.getStatus())
                    .build();
            appointmentRepository.save(appointment);

            return ResponseEntity.ok(Response.builder()
                            .responseCode(ResponseUtils.SUCCESS_MESSAGE_CODE)
                            .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
                            .data(Data.builder()
                                    .name(patients.getFirstName()+" "+patients.getLastName())
                                    .description(appointmentRequest.getStatus())
                                    .email(appointmentRequest.getEmail())
                                    .build())
                    .build());
        }else return ResponseEntity.ofNullable(Response.builder()
                        .responseCode(ResponseUtils.USER_NOT_FOUND_CODE)
                        .responseMessage(ResponseUtils.USER_NOT_FOUND_MESSAGE)
                        .data(null)
                .build());
    }
}
