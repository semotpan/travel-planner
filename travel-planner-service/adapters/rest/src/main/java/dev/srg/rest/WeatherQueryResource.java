package dev.srg.rest;

import dev.srg.application.QueryCityWeather;
import dev.srg.domain.model.CityName;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

import static java.util.stream.Collectors.toList;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WeatherQueryResource {

    private final QueryCityWeather queryCityWeather;

    @GetMapping("/weather")
    ResponseEntity<?> query(CityQuery cityQuery) {
        var cityWeathers = queryCityWeather.find(CityName.valueOf(cityQuery.getCity()));
        return new ResponseEntity<>(cityWeathers.stream()
                .map(cityWeather -> WeatherResponse.builder()
                        .withCityName(cityWeather.getCityName().getValue())
                        .withCountryCode(cityWeather.getCountryCode().getValue())
                        .withTemperature(cityWeather.getTemperature().getValue())
                        .withClouds(cityWeather.getClouds().getValue())
                        .withWeatherTime(cityWeather.getWeatherDateTime().getValue())
                        .build())
                .collect(toList()), HttpStatus.OK);
    }

    @Data
    private static class CityQuery {

        public String city;

        @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
        public Date date;

    }

    @Data
    private static class WeatherResponse {

        private String cityName;
        private String countryCode;
        private Double temperature;
        private Integer clouds;
        private Instant weatherTime;

        static Builder builder() {
            return new Builder();
        }

        private static class Builder {
            private String cityName;
            private String countryCode;
            private Double temperature;
            private Integer clouds;
            private Instant weatherTime;

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

            private Builder withClouds(Integer clouds) {
                this.clouds = clouds;
                return this;
            }

            private Builder withWeatherTime(Instant weatherTime) {
                this.weatherTime = weatherTime;
                return this;
            }

            private WeatherResponse build() {
                WeatherResponse weatherResponse = new WeatherResponse();
                weatherResponse.cityName = cityName;
                weatherResponse.countryCode = countryCode;
                weatherResponse.temperature = temperature;
                weatherResponse.clouds = clouds;
                weatherResponse.weatherTime = weatherTime;
                return weatherResponse;
            }
        }
    }
}
