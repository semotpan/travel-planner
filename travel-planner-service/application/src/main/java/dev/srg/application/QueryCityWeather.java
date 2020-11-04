package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;

import java.util.List;

public interface QueryCityWeather {

    List<CityWeather> find(CityName cityName);

    static QueryCityWeather createQueryCityWeather(CityWeathers cityWeathers) {
        return new QueryCityWeatherService(cityWeathers);
    }
}
