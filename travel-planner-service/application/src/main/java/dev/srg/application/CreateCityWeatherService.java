package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class CreateCityWeatherService implements CreateCityWeather {

    private final CityWeathers cityWeathers;

    @Override
    public void create(CityWeather cityWeather) {
        cityWeathers.save(cityWeather);
    }
}
