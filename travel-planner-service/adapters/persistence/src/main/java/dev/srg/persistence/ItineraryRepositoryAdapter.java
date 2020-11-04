package dev.srg.persistence;

import dev.srg.domain.model.Itineraries;
import dev.srg.domain.model.Itinerary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.util.stream.Collectors.toList;

@Repository
@RequiredArgsConstructor
class ItineraryRepositoryAdapter implements Itineraries {

    private final ItineraryRepository itineraryRepository;

    @Override
    public void save(Itinerary itinerary) {
        itineraryRepository.save(ItineraryTable.builder()
                .withName(itinerary.getName().getValue())
                .withItineraryMap(ItineraryTable.ItineraryMap.valueOf(itinerary.getItineraryMap().stream()
                        .map(cityWeather -> ItineraryTable.CityWeatherInfo.builder()
                                .withCityName(cityWeather.getCityName().getValue())
                                .withCountryCode(cityWeather.getCountryCode().getValue())
                                .withTemperatureValue(cityWeather.getTemperature().getValue())
                                .withTemperatureUnit(cityWeather.getTemperature().getUnit())
                                .withCloudsValue(cityWeather.getClouds().getValue())
                                .withCloudsUnit(cityWeather.getClouds().getUnit())
                                .withWeatherDateTime(cityWeather.getWeatherDateTime().getValue())
                                .withIssuedOn(cityWeather.getIssuedOn().getValue())
                                .build())
                        .collect(toList())))
                .build());
    }
}
