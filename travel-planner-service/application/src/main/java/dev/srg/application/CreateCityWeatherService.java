package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class CreateCityWeatherService implements CreateCityWeather {

    private final CityWeathers cityWeathers;

    @Override
    public void append(List<CityWeather> cityWeather) {
        cityWeathers.save(cityWeather);
    }
}
