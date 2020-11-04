package dev.srg.persistence;

import dev.srg.domain.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@Entity(name = "city_weather")
class CityWeatherTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_WTH", allocationSize = 1)
    private Long id;

    private String cityName;
    private String countryCode;
    private Double temperatureValue;
    private Temperature.Unit temperatureUnit;
    private Integer cloudsValue;
    private Clouds.Unit cloudsUnit;
    private Instant weatherDate;
    private Instant issuedOn;

    CityWeather toCityWeather() {
        return CityWeather.builder()
                .withCityName(CityName.valueOf(cityName))
                .withCountryCode(CountryCode.valueOf(countryCode))
                .withTemperature(Temperature.valueOf(temperatureValue, temperatureUnit))
                .withClouds(Clouds.valueOf(cloudsValue, cloudsUnit))
                .withWeatherDate(WeatherDate.valueOf(weatherDate))
                .withIssuedOn(IssuedOn.valueOf(issuedOn))
                .build();
    }

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
        private Instant weatherDate;
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

        Builder withWeatherDate(Instant weatherDate) {
            this.weatherDate = weatherDate;
            return this;
        }

        Builder withIssuedOn(Instant issuedOn) {
            this.issuedOn = issuedOn;
            return this;
        }

        CityWeatherTable build() {
            CityWeatherTable cityWeatherTable = new CityWeatherTable();
            cityWeatherTable.setCityName(cityName);
            cityWeatherTable.setCountryCode(countryCode);
            cityWeatherTable.setTemperatureValue(temperatureValue);
            cityWeatherTable.setTemperatureUnit(temperatureUnit);
            cityWeatherTable.setCloudsValue(cloudsValue);
            cityWeatherTable.setCloudsUnit(cloudsUnit);
            cityWeatherTable.setWeatherDate(weatherDate);
            cityWeatherTable.setIssuedOn(issuedOn);
            return cityWeatherTable;
        }
    }
}
