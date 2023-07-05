package com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRequest {
    private String model;
    private List<ChatMessage> messages;

    public ChatRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new ChatMessage("user", prompt));
    }
}
