package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;

import java.util.List;

public interface QueryCityWeatherUseCase {

    List<CityWeather> find(CityName cityName);

    static QueryCityWeatherUseCase createQueryCityWeather(CityWeathers cityWeathers) {
        return new QueryCityWeatherUseCaseService(cityWeathers);
    }
}
