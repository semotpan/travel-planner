package dev.srg.rest;

import dev.srg.domain.model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;

import static dev.srg.domain.model.Clouds.Unit.PERCENTAGE;
import static dev.srg.domain.model.Temperature.Unit.CELSIUS;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;

@Component
@RequiredArgsConstructor
final class OpenWeatherMapService implements WeatherApi {

    private final RestTemplate restTemplate = new RestTemplate();
    private final OpenWeatherMapProperties properties;

    @Override
    public List<CityWeather> lookup(String city) {
        var response = restTemplate.getForEntity(properties.url() + "&q=" + city, CityWeatherForecast.class);
        // TODO review exception handling
        if (OK == response.getStatusCode() && response.getBody() != null) {
            var issuedOn = Instant.now();
            return response.getBody().getList().stream()
                    .map(value -> CityWeather.builder()
                            .withCityName(CityName.valueOf(city))
                            .withCountryCode(CountryCode.valueOf(response.getBody().getCity().getCountry()))
                            .withTemperature(Temperature.valueOf(value.getMain().getTemp(), CELSIUS))
                            .withClouds(Clouds.valueOf(value.getClouds().getAll(), PERCENTAGE))
                            .withWeatherDate(WeatherDateTime.valueOf(value.getDt()))
                            .withIssuedOn(IssuedOn.valueOf(issuedOn))
                            .build())
                    .collect(toList());
        }

        return List.of();
    }

    @Data
    private static class CityWeatherForecast {
        private List<WeatherForecastHourly> list;
        private CityHourly city;
    }

    @Data
    private static class WeatherForecastHourly {
        private Instant dt;
        private TemperatureHourly main;
        private CloudsHourly clouds;
    }

    @Data
    private static class TemperatureHourly {
        private Double temp;
    }

    @Data
    private static class CloudsHourly {
        private Integer all;
    }

    @Data
    private static class CityHourly {
        private String name;
        private String country;
    }
}
