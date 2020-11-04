package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
final class QueryCityWeatherUseCaseService implements QueryCityWeatherUseCase {

    private final CityWeathers cityWeathers;

    @Override
    public List<CityWeather> find(CityName cityName) {
        log.debug("Query city weathers by {}", cityName);
        return cityWeathers.find(cityName);
    }
}
