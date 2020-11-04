package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;

import java.util.List;

public interface CreateCityWeather {

    void append(List<CityWeather> cityWeathers);

    static CreateCityWeather createCityWeather(CityWeathers cityWeathers) {
        return new CreateCityWeatherService(cityWeathers);
    }
}
