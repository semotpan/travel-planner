package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;

public interface CreateCityWeather {

    void create(CityWeather cityWeather);

    static CreateCityWeather createCityWeather(CityWeathers cityWeathers) {
        return new CreateCityWeatherService(cityWeathers);
    }
}
