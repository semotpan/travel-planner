package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import dev.srg.domain.model.WeatherDateTime;

public interface QueryCityWeatherUseCase {

    CityWeather find(CityName cityName, WeatherDateTime weatherDateTime);

    static QueryCityWeatherUseCase createQueryCityWeather(CityWeathers cityWeathers) {
        return new QueryCityWeatherUseCaseService(cityWeathers);
    }
}
