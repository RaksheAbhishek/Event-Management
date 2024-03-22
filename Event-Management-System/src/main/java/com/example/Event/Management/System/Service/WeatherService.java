package com.example.Event.Management.System.Service;

import java.time.LocalDate;

public interface WeatherService {
    String getWeather(String city, String date);

	String getWeather(String city, LocalDate date);

}
