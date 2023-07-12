package com.Vitality_Hub.Virtual_Health_Assisstant.appointment.controller;

import com.Vitality_Hub.Virtual_Health_Assisstant.Response.Response;
import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.dto.AppointmentRequest;
import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<Response> bookAppointment(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.bookAppointment(appointmentRequest);
    }

}
