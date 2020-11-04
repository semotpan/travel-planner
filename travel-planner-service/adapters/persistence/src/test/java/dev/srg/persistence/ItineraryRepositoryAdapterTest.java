package dev.srg.persistence;

import dev.srg.domain.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import java.util.List;

import static dev.srg.domain.model.Clouds.Unit.PERCENTAGE;
import static dev.srg.domain.model.Temperature.Unit.CELSIUS;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:/persistence-test.properties")
class ItineraryRepositoryAdapterTest {

    @Autowired
    ItineraryRepositoryAdapter itineraryRepositoryAdapter;

    @Autowired
    EntityManager entityManager;

    @Test
    void persist() {
        var date = IssuedOn.newValue();
        itineraryRepositoryAdapter.save(Itinerary.valueOf(ItineraryName.valueOf("itinerary1"),
                List.of(CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                        .withIssuedOn(date)
                        .build())));

        assertThat(entityManager.find(ItineraryTable.class, 1L))
                .isNotNull()
                .extracting(ItineraryTable::toItinerary)
                .isEqualTo(Itinerary.valueOf(ItineraryName.valueOf("itinerary1"),
                        List.of(CityWeather.builder()
                                .withCityName(CityName.valueOf("Chisinau"))
                                .withCountryCode(CountryCode.valueOf("MD"))
                                .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                                .withClouds(Clouds.valueOf(1, PERCENTAGE))
                                .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                                .withIssuedOn(date)
                                .build())));
    }
}