package dev.srg.persistence;

import dev.srg.domain.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static dev.srg.domain.model.Clouds.Unit.PERCENTAGE;
import static dev.srg.domain.model.Temperature.Unit.CELSIUS;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:/persistence-test.properties")
class CityWeathersRepositoryAdapterTest {

    @Autowired
    CityWeathersRepositoryAdapter repository;

    @Autowired
    EntityManager entityManager;

    @Transactional
    @Test
    void persist() {
        final IssuedOn date = IssuedOn.newValue();
        repository.save(List.of(CityWeather.builder()
                .withCityName(CityName.valueOf("Chisinau"))
                .withCountryCode(CountryCode.valueOf("MD"))
                .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                .withClouds(Clouds.valueOf(1, PERCENTAGE))
                .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                .withIssuedOn(date)
                .build()));


        assertThat(repository.find(CityName.valueOf("Chisinau")))
                .isNotNull()
                .containsExactly(CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                        .withIssuedOn(date)
                        .build());
    }

    @Transactional
    @Test
    void notFound() {
        final IssuedOn date = IssuedOn.newValue();
        repository.save(List.of(CityWeather.builder()
                .withCityName(CityName.valueOf("Chisinau"))
                .withCountryCode(CountryCode.valueOf("MD"))
                .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                .withClouds(Clouds.valueOf(1, PERCENTAGE))
                .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                .withIssuedOn(IssuedOn.valueOf(Instant.now().minus(2, ChronoUnit.HOURS)))
                .build()));

        assertThat(repository.find(CityName.valueOf("Chisinau"))).isEmpty();
    }
}