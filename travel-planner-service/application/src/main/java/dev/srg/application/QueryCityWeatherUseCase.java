package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import dev.srg.domain.model.WeatherDateTime;

import java.util.Optional;

public interface QueryCityWeatherUseCase {

    Optional<CityWeather> find(CityName cityName, WeatherDateTime weatherDateTime);

    static QueryCityWeatherUseCase createQueryCityWeather(CityWeathers cityWeathers) {
        return new QueryCityWeatherService(cityWeathers);
    }
}
