package dev.srg.application;

import dev.srg.domain.model.CityWeather;

import java.util.List;

public interface CreateCityWeather {

    void append(List<CityWeather> cityWeathers);
}
