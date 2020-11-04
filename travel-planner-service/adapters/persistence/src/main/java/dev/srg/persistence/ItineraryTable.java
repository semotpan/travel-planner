package dev.srg.persistence;

import dev.srg.domain.model.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "itinerary")
class ItineraryTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_IT")
    @SequenceGenerator(name = "SEQ_GEN_IT", sequenceName = "SEQ_IT", allocationSize = 1)
    private Long id;

    private String name;

    @Convert(converter = ItineraryMapConverter.class)
    @Column(name = "itineraryMap", columnDefinition = "json")
    private ItineraryMap itineraryMap;

    static Builder builder() {
        return new Builder();
    }

    public Itinerary toItinerary() {
        return Itinerary.valueOf(ItineraryName.valueOf(name),
                itineraryMap.getCitiesItinerary().stream()
                        .map(cityWeatherInfo -> CityWeather.builder()
                                .withCityName(CityName.valueOf(cityWeatherInfo.getCityName()))
                                .withCountryCode(CountryCode.valueOf(cityWeatherInfo.getCountryCode()))
                                .withTemperature(Temperature.valueOf(cityWeatherInfo.getTemperatureValue(), cityWeatherInfo.getTemperatureUnit()))
                                .withClouds(Clouds.valueOf(cityWeatherInfo.getCloudsValue(), cityWeatherInfo.getCloudsUnit()))
                                .withWeatherDateTime(WeatherDateTime.valueOf(cityWeatherInfo.getWeatherDateTime()))
                                .withIssuedOn(IssuedOn.valueOf(cityWeatherInfo.getIssuedOn()))
                                .build())
                        .collect(toList()));
    }

    static final class Builder {
        private String name;
        private ItineraryMap itineraryMap;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withItineraryMap(ItineraryMap itineraryMap) {
            this.itineraryMap = itineraryMap;
            return this;
        }

        public ItineraryTable build() {
            ItineraryTable itineraryTable = new ItineraryTable();
            itineraryTable.setName(name);
            itineraryTable.setItineraryMap(itineraryMap);
            return itineraryTable;
        }
    }

    @EqualsAndHashCode
    @Setter
    @Getter
    static class ItineraryMap implements Serializable {

        private List<CityWeatherInfo> citiesItinerary;

        static ItineraryMap valueOf(List<CityWeatherInfo> citiesItinerary) {
            ItineraryMap itineraryMap = new ItineraryMap();
            itineraryMap.setCitiesItinerary(new LinkedList<>(citiesItinerary));
            return itineraryMap;
        }
    }

    @EqualsAndHashCode
    @Setter
    @Getter
    static class CityWeatherInfo implements Serializable {

        private String cityName;
        private String countryCode;
        private Double temperatureValue;
        private Temperature.Unit temperatureUnit;
        private Integer cloudsValue;
        private Clouds.Unit cloudsUnit;
        private Instant weatherDateTime;
        private Instant issuedOn;

        static Builder builder() {
            return new Builder();
        }

        static final class Builder {
            private String cityName;
            private String countryCode;
            private Double temperatureValue;
            private Temperature.Unit temperatureUnit;
            private Integer cloudsValue;
            private Clouds.Unit cloudsUnit;
            private Instant weatherDateTime;
            private Instant issuedOn;

            private Builder() {
            }

            Builder withCityName(String cityName) {
                this.cityName = cityName;
                return this;
            }

            Builder withCountryCode(String countryCode) {
                this.countryCode = countryCode;
                return this;
            }

            Builder withTemperatureValue(Double temperatureValue) {
                this.temperatureValue = temperatureValue;
                return this;
            }

            Builder withTemperatureUnit(Temperature.Unit temperatureUnit) {
                this.temperatureUnit = temperatureUnit;
                return this;
            }

            Builder withCloudsValue(Integer cloudsValue) {
                this.cloudsValue = cloudsValue;
                return this;
            }

            Builder withCloudsUnit(Clouds.Unit cloudsUnit) {
                this.cloudsUnit = cloudsUnit;
                return this;
            }

            Builder withWeatherDateTime(Instant weatherDateTime) {
                this.weatherDateTime = weatherDateTime;
                return this;
            }

            Builder withIssuedOn(Instant issuedOn) {
                this.issuedOn = issuedOn;
                return this;
            }

            CityWeatherInfo build() {
                CityWeatherInfo cityWeatherInfo = new CityWeatherInfo();
                cityWeatherInfo.setCityName(cityName);
                cityWeatherInfo.setCountryCode(countryCode);
                cityWeatherInfo.setTemperatureValue(temperatureValue);
                cityWeatherInfo.setTemperatureUnit(temperatureUnit);
                cityWeatherInfo.setCloudsValue(cloudsValue);
                cityWeatherInfo.setCloudsUnit(cloudsUnit);
                cityWeatherInfo.setWeatherDateTime(weatherDateTime);
                cityWeatherInfo.setIssuedOn(issuedOn);
                return cityWeatherInfo;
            }
        }
    }
}
