package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static dev.srg.domain.model.Clouds.Unit.PERCENTAGE;
import static dev.srg.domain.model.Temperature.Unit.CELSIUS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class CityWeatherTest {

    @Test
    void creation() {
        final IssuedOn date = IssuedOn.newValue();
        assertThat(CityWeather.builder()
                .withCityName(CityName.valueOf("Chisinau"))
                .withCountryCode(CountryCode.valueOf("MD"))
                .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                .withClouds(Clouds.valueOf(1, PERCENTAGE))
                .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                .withIssuedOn(date)
                .build())
                .isNotNull()
                .isEqualTo(CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withWeatherDate(WeatherDateTime.valueOf(date.getValue()))
                        .withIssuedOn(date)
                        .build());
    }

    @Test
    void creationFailsWhenCityNameIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> CityWeather.builder()
                        .withCityName(null)
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withIssuedOn(IssuedOn.newValue())
                        .build())
                .withMessage("City Name cannot be null");
    }

    @Test
    void creationFailsWhenCountryCodeIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(null)
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withIssuedOn(IssuedOn.newValue())
                        .build())
                .withMessage("Country Code cannot be null");
    }

    @Test
    void creationFailsWhenTemperatureIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(null)
                        .withClouds(Clouds.valueOf(1, PERCENTAGE))
                        .withIssuedOn(IssuedOn.newValue())
                        .build())
                .withMessage("Temperature cannot be null");
    }

    @Test
    void creationFailsWhenCloudsIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> CityWeather.builder()
                        .withCityName(CityName.valueOf("Chisinau"))
                        .withCountryCode(CountryCode.valueOf("MD"))
                        .withTemperature(Temperature.valueOf(10.0, CELSIUS))
                        .withIssuedOn(IssuedOn.newValue())
                        .withClouds(null)
                        .build())
                .withMessage("Clouds cannot be null");
    }
}