package dev.srg.application;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import dev.srg.domain.model.WeatherDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Slf4j
@Component
@RequiredArgsConstructor
final class QueryCityWeatherService implements QueryCityWeatherUseCase {

    private final CityWeathers cityWeathers;

    @Override
    public Optional<CityWeather> find(CityName cityName, WeatherDateTime weatherDateTime) {
        log.debug("Query city weathers by {}", cityName);
        List<CityWeather> cityWeathers = this.cityWeathers.find(cityName);

        if (cityWeathers.isEmpty()) {
            return Optional.empty();
        }

        TreeMap<WeatherDateTime, List<CityWeather>> forecastHourly = cityWeathers
                .stream()
                .collect(groupingBy((CityWeather::getWeatherDateTime), TreeMap::new, toList()));

        return forecastHourly.floorEntry(weatherDateTime).getValue()
                .stream()
                .findAny();
    }
}
