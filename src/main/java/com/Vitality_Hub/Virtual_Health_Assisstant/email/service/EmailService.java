package com.Vitality_Hub.Virtual_Health_Assisstant.email.service;

import com.Vitality_Hub.Virtual_Health_Assisstant.email.dto.EmailDetails;

public interface EmailService {
    String sendSimpleEmail(EmailDetails emailDetails);

}
