package com.Vitality_Hub.Virtual_Health_Assisstant.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    private String email;
    private String appointmentDate;
    private String notes;
    private String status;

}
