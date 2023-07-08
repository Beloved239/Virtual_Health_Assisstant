package com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.controller;


import com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.Response.ChatResponse;
import com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.dto.ChatRequest;
//import com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

//    @Autowired
//    ChatBotService chatBotService;

//    @Autowired
//    RestTemplateConfiguration restTemplateConfiguration;



//    @GetMapping
//    public String chatBot(@RequestParam("prompt") String prompt){
//       return chatBotService.chatBot(prompt);
//    }

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(60000))
                .setReadTimeout(Duration.ofMillis(60000))
                .build();
    }

    @GetMapping
    public String chatBot(String prompt){

        ChatRequest request = new ChatRequest(model, prompt);

        //call API
        ChatResponse response =
                restTemplate.postForObject(apiUrl, request,ChatResponse.class);


        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()){
            return "No Response";
        }

        return response.getChoices().get(0).getMessage().getContent();
    }


}
