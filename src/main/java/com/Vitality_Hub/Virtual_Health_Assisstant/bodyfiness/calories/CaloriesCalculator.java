package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.calories;

import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/calories")
public class CaloriesCalculator {
    private static final String API_URL ="https://calories-burned-by-api-ninjas.p.rapidapi.com/v1/caloriesburned?activity=skiing";
    private static final String API_KEY = "660a5648f2msh175b920c0ee1419p147b9bjsn2edfadcbba36";
    private static final String API_KEY_NAME = "X-RapidAPI-Key";
    private static final String API_HOST = "calories-burned-by-api-ninjas.p.rapidapi.com";
    private static final String API_HOST_NAME = "X-RapidAPI-Host";

    private final OkHttpClient client = new OkHttpClient();

    @GetMapping("/loss")
    public String caloriesBurn() throws IOException {
        Request request = new Request.Builder()
                .url(API_URL)
                .get()
                .addHeader(API_KEY_NAME, API_KEY)
                .addHeader(API_HOST_NAME, API_HOST)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new IOException("Request failed: " + response);
            }
        }
    }
}
