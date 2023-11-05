package com.example.izzi.Izzi.services;

import com.example.izzi.Izzi.models.dataipModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IpGeo {
    private final OkHttpClient client = new OkHttpClient();

    private final ObjectMapper objectMapper;

    public IpGeo(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public dataipModel getInfo(String ip) throws IOException {

        String apiUrl = "https://ip-geo-location.p.rapidapi.com/ip/check?format=json&ip=" + ip;

        // Construir la solicitud con el cuerpo JSON
        Request request = new Request.Builder()
                .url(apiUrl)
                .get() // Cambiar de GET a POST para enviar el JSON en el cuerpo
                .addHeader("X-RapidAPI-Key", "59ee567f7cmsh5d2ab59a071a97ap12fb08jsn29581c073246")
                .addHeader("X-RapidAPI-Host", "ip-geo-location.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, dataipModel.class);
        } else {
            System.err.println("Error en la solicitud: " + response.code());
            return null;
        }
    }


}
