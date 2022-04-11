package com.testtask.test_rest.service;

import com.testtask.test_rest.model.Weather;

import java.util.List;

public interface WeatherService {

    Weather getWeatherByColleagueId(Integer id);

    List<Weather> getAllWeather();

}
