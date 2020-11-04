package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;

import java.util.List;

public interface CreateCityWeatherUseCase {

    void append(List<CityWeather> cityWeathers);

    static CreateCityWeatherUseCase createCityWeather(CityWeathers cityWeathers) {
        return new CreateCityWeatherService(cityWeathers);
    }
}
