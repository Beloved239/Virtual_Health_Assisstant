package com.Vitality_Hub.Virtual_Health_Assisstant.Security.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.Security.dto.UserInfoUserDetails;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.entity.Patients;
import com.Vitality_Hub.Virtual_Health_Assisstant.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserUserDetailsService implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Patients> userInfo = Optional.ofNullable(patientRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User with provided information not found")));

        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"+ email));
    }
}
