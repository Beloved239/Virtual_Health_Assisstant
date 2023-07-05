package com.Vitality_Hub.Virtual_Health_Assisstant.doctor.entity;

import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.entity.Appointment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctor")
@Builder
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String password;
    private String phoneNumber;
    private String dateOfBirth;
    private String specialization;


    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;


}
