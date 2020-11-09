package dev.srg.rest;

import dev.srg.application.CreateCityWeatherUseCase;
import dev.srg.application.QueryCityWeatherUseCase;
import dev.srg.domain.model.CityName;
import dev.srg.domain.model.CityWeather;
import dev.srg.domain.model.WeatherDateTime;
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
import java.util.Date;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WeatherCreationResource {

    private final WeatherApi weatherApi;
    private final CreateCityWeatherUseCase createCityWeatherUseCase;
    private final QueryCityWeatherUseCase queryCityWeatherUseCase;

    @CrossOrigin
    @PostMapping("/submit-city")
    ResponseEntity<?> submit(@RequestBody CityInfo cityInfo) {

        var weather = queryCityWeatherUseCase.find(CityName.valueOf(cityInfo.getCity()), WeatherDateTime.valueOf(cityInfo.toInstant()));

        if (weather.isEmpty()) {
            log.debug("Weather fetch for {}", cityInfo);
            var cityWeather = weatherApi.lookup(cityInfo.getCity());
            createCityWeatherUseCase.append(cityWeather);
        }

        return ResponseEntity.created(URI.create("/")).build(); // TODO review location
    }

    @Data
    private static class CityInfo {

        String city;

        Date date;

        Instant toInstant() {
            return date.toInstant();
        }

    }
}
