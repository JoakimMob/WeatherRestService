package com.example.weatherapp.Clients;

import com.example.weatherapp.Business.WeatherSMHI.WeatherServiceSMHI;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SMHIClient {

    public WebClient client = WebClient.create();
    public WeatherServiceSMHI weatherService;

    public SMHIClient() {
        weatherService = getWeatherDataSMHI();
    }

    public WeatherServiceSMHI getWeatherDataSMHI() {
        Mono<WeatherServiceSMHI> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(WeatherServiceSMHI.class);
        return mono.block();
    }

}