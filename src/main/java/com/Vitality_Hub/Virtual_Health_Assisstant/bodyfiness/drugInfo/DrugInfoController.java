package com.Vitality_Hub.Virtual_Health_Assisstant.bodyfiness.drugInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/druginfo")
public class DrugInfoController {

    private static final String API_URL = "https://drug-info-and-price-history.p.rapidapi.com/1/druginfo?drug=paracetamol";
    private static final String API_KEY = "d7e02fec38msh7f9d9542149a672p1097c2jsn6c0fd1c41384";
    private static final String API_KEY_NAME = "X-RapidAPI-Key";
    private static final String API_HOST = "drug-info-and-price-history.p.rapidapi.com";
    private static final String API_HOST_NAME = "X-RapidAPI-Host";


    private final OkHttpClient client = new OkHttpClient();

    @GetMapping
    public String getDrugInfo() throws IOException {
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
