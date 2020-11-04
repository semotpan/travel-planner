package dev.srg.rest;

import dev.srg.domain.model.CityWeather;

import java.util.List;

public interface WeatherApi {

    List<CityWeather> lookup(String city);

}
