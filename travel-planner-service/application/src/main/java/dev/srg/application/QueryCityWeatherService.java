package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
final class QueryCityWeatherService implements QueryCityWeather {

    private final CityWeathers cityWeathers;

    @Override
    public List<CityWeather> find(CityName cityName) {
        return cityWeathers.find(cityName);
    }
}
