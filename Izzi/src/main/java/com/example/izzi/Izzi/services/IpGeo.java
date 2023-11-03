package com.example.izzi.Izzi.services;

import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IpGeo {
    OkHttpClient client = new OkHttpClient();

    public interface IpInfoService {
        String getInfo(String ip);
    }

    public IpGeo(String ip) throws IOException {
        String json =  "{\"ip\":\""+ip+"\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);


        Request request = new Request.Builder()
                .url("https://ip-geo-location.p.rapidapi.com/ip/check?format=json")
                .post(requestBody)
                .addHeader("X-RapidAPI-Key", "59ee567f7cmsh5d2ab59a071a97ap12fb08jsn29581c073246")
                .addHeader("X-RapidAPI-Host", "ip-geo-location.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            System.out.println("Respuesta: " + responseBody);
        } else {
            System.err.println("Error en la solicitud: " + response.code());
        }
    }

}
