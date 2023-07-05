package com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.Response;

import com.Vitality_Hub.Virtual_Health_Assisstant.virtualBot.dto.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse {
    private List<Choice> choices;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Choice{
        private int index;
        private ChatMessage message;
    }
}
