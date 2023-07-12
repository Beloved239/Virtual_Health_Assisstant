package com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity;

import com.Vitality_Hub.Virtual_Health_Assisstant.appointment.entity.Appointment;
import com.Vitality_Hub.Virtual_Health_Assisstant.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patient")
@Builder
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String gender;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;


    @ManyToMany(mappedBy = "patients")
    private Set<Appointment> appointment;
}
