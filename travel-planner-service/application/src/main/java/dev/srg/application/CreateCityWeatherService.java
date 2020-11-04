package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
final class CreateCityWeatherService implements CreateCityWeather {

    private final CityWeathers cityWeathers;

    @Override
    public void append(List<CityWeather> cityWeather) {
        cityWeathers.save(cityWeather);
    }
}
