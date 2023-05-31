package com.example.weatherapp.Business.Entities;

import com.example.weatherapp.Clients.SMHIClient;
import org.springframework.stereotype.Component;

@Component
public class SMHIEntity extends WeatherWebsiteTemplate {
    SMHIClient smhiClient;
    public SMHIEntity(){
        smhiClient = new SMHIClient();
        dataSource = "SMHI";
    }




}
