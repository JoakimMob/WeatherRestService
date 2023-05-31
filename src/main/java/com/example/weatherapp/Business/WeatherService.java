package com.example.weatherapp.Business;

import org.springframework.web.reactive.function.client.WebClient;

public class WeatherService {
    private final WebClient webClient;

    public WeatherService(WebClient webClient) {
        this.webClient = WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }




}