package dev.srg.rest;

import dev.srg.application.CreateItineraryUseCase;
import dev.srg.domain.model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RequiredArgsConstructor
@RestController
class ItineraryCreationResource {

    private final CreateItineraryUseCase createItineraryUseCase;

    @CrossOrigin
    @PostMapping("/itinerary")
    ResponseEntity<?> submit(@RequestBody ItineraryInfo itineraryInfo) {
        createItineraryUseCase.create(Itinerary.valueOf(ItineraryName.valueOf(itineraryInfo.getName()),
                itineraryInfo.getItineraryMap().stream()
                        .map(weatherInfo -> CityWeather.builder()
                                .withCityName(CityName.valueOf(weatherInfo.getCityName()))
                                .withCountryCode(CountryCode.valueOf(weatherInfo.getCountryCode()))
                                .withTemperature(Temperature.valueOf(weatherInfo.getTemperature(), weatherInfo.getTemperatureUnit()))
                                .withClouds(Clouds.valueOf(weatherInfo.getClouds(), weatherInfo.getCloudsUnit()))
                                .withWeatherDateTime(WeatherDateTime.valueOf(weatherInfo.getWeatherDateTime()))
                                .withIssuedOn(IssuedOn.valueOf(weatherInfo.getIssuedOn()))
                                .build())
                        .collect(toList())));
        return ResponseEntity.created(URI.create("/")).build(); // TODO review location
    }

    @Data
    private static class ItineraryInfo {

        public String name;

        public List<WeatherInfo> itineraryMap;

    }

    @Data
    private static class WeatherInfo {

        private String cityName;
        private String countryCode;
        private Double temperature;
        private Temperature.Unit temperatureUnit;
        private Integer clouds;
        private Clouds.Unit cloudsUnit;
        private Instant weatherDateTime;
        private Instant issuedOn;
    }
}
