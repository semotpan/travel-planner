package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
final class QueryCityWeatherService implements QueryCityWeather {

    private final CityWeathers cityWeathers;

    @Override
    public List<CityWeather> find(CityName cityName) {
        return cityWeathers.find(cityName);
    }
}
