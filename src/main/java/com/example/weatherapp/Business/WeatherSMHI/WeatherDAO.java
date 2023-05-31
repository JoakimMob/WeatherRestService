package com.example.weatherapp.Business.WeatherSMHI;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

public class WeatherDAO {

    WebClient client = WebClient
            .builder()
            .baseUrl("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
            .build();
    public Flux<TimeSeries> getWeatherDataSMHI(){
        return this.client
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(TimeSeries.class);
    }
    public void findSpeficParametersAndTime(int time){
        List<TimeSeries> weathersList =  getWeatherDataSMHI().collectList().block().stream().toList();
        weathersList.stream().forEach(System.out::println);

    }
}