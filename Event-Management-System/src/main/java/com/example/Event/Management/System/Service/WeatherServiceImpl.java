package com.example.Event.Management.System.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Value("${weather.api.key}")
    private String weatherApiKey;

    @Override
    public String getWeather(String city, String date) {
        String apiUrl = weatherApiUrl + "?key=" + weatherApiKey + "&city=" + city + "&date=" + date;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        return responseEntity.getBody();
    }

    @Override
    public String getWeather(String city, LocalDate date) {
        String formattedDate = date.toString();
        return getWeather(city, formattedDate);
    }
}
