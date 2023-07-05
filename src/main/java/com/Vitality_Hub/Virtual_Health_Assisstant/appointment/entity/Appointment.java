package com.Vitality_Hub.Virtual_Health_Assisstant.appointment.entity;

import com.Vitality_Hub.Virtual_Health_Assisstant.doctor.entity.Doctors;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity.Patients;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "appointment")
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate appointmentDate;
    private String notes;
    private String status;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "patient_appointment",
            joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id")
    )
    @JoinColumn(name = "patients_id")
    private Set<Patients> patients;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_appointment",
            joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    )
    private Doctors doctor;


}
