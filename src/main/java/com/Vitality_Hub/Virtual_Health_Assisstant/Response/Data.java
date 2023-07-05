package com.Vitality_Hub.Virtual_Health_Assisstant.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Data {
    private String name;
    private String email;
    private String description;
}
