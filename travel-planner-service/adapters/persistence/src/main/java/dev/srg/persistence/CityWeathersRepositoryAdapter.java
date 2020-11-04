package dev.srg.persistence;

import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.CityWeathers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Repository
class CityWeathersRepositoryAdapter implements CityWeathers {

    private final CityWeatherRepository cityWeatherRepository;
    private final EntityManager entityManager;

    @Transactional
    @Override
    public void save(List<CityWeather> cityWeathers) {
        cityWeatherRepository.saveAll(cityWeathers.stream()
                .map(cityWeather -> CityWeatherTable.builder()
                        .withCityName(cityWeather.getCityName().getValue())
                        .withCountryCode(cityWeather.getCountryCode().getValue())
                        .withTemperatureValue(cityWeather.getTemperature().getValue())
                        .withTemperatureUnit(cityWeather.getTemperature().getUnit())
                        .withCloudsValue(cityWeather.getClouds().getValue())
                        .withCloudsUnit(cityWeather.getClouds().getUnit())
                        .withWeatherDateTime(cityWeather.getWeatherDateTime().getValue())
                        .withIssuedOn(cityWeather.getIssuedOn().getValue())
                        .build()).collect(toList()));
    }

    @Override
    public List<CityWeather> find(CityName cityName) {
        return entityManager.createQuery("Select t from city_weather t where t.cityName='" + cityName.getValue() + "' and t.issuedOn > '" + Instant.now().minus(1, ChronoUnit.HOURS) + "'", CityWeatherTable.class)
                .getResultList().stream()
                .map(CityWeatherTable::toCityWeather)
                .collect(toList());
    }
}
