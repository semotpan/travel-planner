package dev.srg.rest;

import dev.srg.application.QueryCityWeatherUseCase;
import dev.srg.domain.model.CityName;
import dev.srg.domain.model.Clouds;
import dev.srg.domain.model.Temperature;
import dev.srg.domain.model.WeatherDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@RequiredArgsConstructor
@RestController
class WeatherQueryResource {

    private final QueryCityWeatherUseCase queryCityWeatherUseCase;

    @CrossOrigin
    @GetMapping("/weather")
    ResponseEntity<?> query(CityQuery cityQuery) {
        var cityWeather = queryCityWeatherUseCase.find(CityName.valueOf(cityQuery.getCity()), WeatherDateTime.valueOf(cityQuery.toInstant()));
        return new ResponseEntity<>(WeatherResponse.builder()
                .withCityName(cityWeather.getCityName().getValue())
                .withCountryCode(cityWeather.getCountryCode().getValue())
                .withTemperature(cityWeather.getTemperature().getValue())
                .withTemperatureUnit(cityWeather.getTemperature().getUnit())
                .withClouds(cityWeather.getClouds().getValue())
                .withCloudsUnit(cityWeather.getClouds().getUnit())
                .withWeatherDateTime(cityWeather.getWeatherDateTime().getValue())
                .withIssuedOn(cityWeather.getIssuedOn().getValue())
                .build(), HttpStatus.OK);
    }

    @Data
    private static class CityQuery {

        String city;

        String date;

        Instant toInstant() {
            return LocalDateTime.parse(date).toInstant(ZoneOffset.UTC);
        }

    }

    @Data
    private static class WeatherResponse {

        private String cityName;
        private String countryCode;
        private Double temperature;
        private Temperature.Unit temperatureUnit;
        private Integer clouds;
        private Clouds.Unit cloudsUnit;
        private Instant weatherDateTime;
        private Instant issuedOn;

        static Builder builder() {
            return new Builder();
        }

        private static class Builder {

            private String cityName;
            private String countryCode;
            private Double temperature;
            private Temperature.Unit temperatureUnit;
            private Integer clouds;
            private Clouds.Unit cloudsUnit;
            private Instant weatherDateTime;
            private Instant issuedOn;

            private Builder() {
            }

            private Builder withCityName(String cityName) {
                this.cityName = cityName;
                return this;
            }

            private Builder withCountryCode(String countryCode) {
                this.countryCode = countryCode;
                return this;
            }

            private Builder withTemperature(Double temperature) {
                this.temperature = temperature;
                return this;
            }

            private Builder withTemperatureUnit(Temperature.Unit temperatureUnit) {
                this.temperatureUnit = temperatureUnit;
                return this;
            }

            private Builder withClouds(Integer clouds) {
                this.clouds = clouds;
                return this;
            }

            private Builder withCloudsUnit(Clouds.Unit cloudsUnit) {
                this.cloudsUnit = cloudsUnit;
                return this;
            }

            private Builder withWeatherDateTime(Instant weatherDateTime) {
                this.weatherDateTime = weatherDateTime;
                return this;
            }

            private Builder withIssuedOn(Instant issuedOn) {
                this.issuedOn = issuedOn;
                return this;
            }

            private WeatherResponse build() {
                WeatherResponse weatherResponse = new WeatherResponse();
                weatherResponse.cityName = cityName;
                weatherResponse.countryCode = countryCode;
                weatherResponse.temperature = temperature;
                weatherResponse.temperatureUnit = temperatureUnit;
                weatherResponse.clouds = clouds;
                weatherResponse.cloudsUnit = cloudsUnit;
                weatherResponse.weatherDateTime = weatherDateTime;
                weatherResponse.issuedOn = issuedOn;
                return weatherResponse;
            }
        }
    }
}
