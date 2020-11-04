package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static dev.srg.domain.model.Clouds.Unit.PERCENTAGE;
import static dev.srg.domain.model.Temperature.Unit.CELSIUS;
import static org.assertj.core.api.Assertions.*;

@Tag("unit")
class ItineraryTest {
    @Test
    void creation() {
        final Instant date = Instant.now();
        assertThat(Itinerary.valueOf(ItineraryName.valueOf("itinerary"), List.of(CityWeather.builder()
                .withCityName(CityName.valueOf("Chisinau"))
                .withCountryCode(CountryCode.valueOf("MD"))
                .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                .withClouds(Clouds.valueOf(1, PERCENTAGE))
                .withWeatherDateTime(WeatherDateTime.valueOf(date))
                .withIssuedOn(IssuedOn.valueOf(date))
                .build())))
                .isNotNull()
                .isEqualTo(Itinerary.valueOf(ItineraryName.valueOf("itinerary"), List.of(CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withWeatherDateTime(WeatherDateTime.valueOf(date))
                        .withIssuedOn(IssuedOn.valueOf(date))
                        .build())));
    }

    @Test
    void creationFailsWhenItineraryNameIsNull() {
        final Instant date = Instant.now();

        assertThatNullPointerException()
                .isThrownBy(() -> Itinerary.valueOf(null, List.of(CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withWeatherDateTime(WeatherDateTime.valueOf(date))
                        .withIssuedOn(IssuedOn.valueOf(date))
                        .build())))
                .withMessage("The Itinerary Name cannot be null");
    }

    @Test
    void creationFailsWhenCitiesItineraryIsEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Itinerary.valueOf(ItineraryName.valueOf("itinerary"), null))
                .withMessage("The Itinerary Map cannot be empty");
    }
}