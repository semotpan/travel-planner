package dev.srg.application;

import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
final class CreateCityWeatherService implements CreateCityWeatherUseCase {

    private final CityWeathers cityWeathers;

    @Override
    public void append(List<CityWeather> cityWeather) {
        log.debug("Save city weathers {}", cityWeather);
        cityWeathers.save(cityWeather);
    }
}
