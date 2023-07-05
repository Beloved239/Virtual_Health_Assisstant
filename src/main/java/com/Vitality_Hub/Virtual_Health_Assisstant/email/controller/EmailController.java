package com.Vitality_Hub.Virtual_Health_Assisstant.email.controller;

import com.Vitality_Hub.Virtual_Health_Assisstant.email.dto.EmailDetails;
import com.Vitality_Hub.Virtual_Health_Assisstant.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mail")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/senderMail")
    public String sendEmail(@RequestBody EmailDetails emailDetails){
        return emailService.sendSimpleEmail(emailDetails);
    }
}
