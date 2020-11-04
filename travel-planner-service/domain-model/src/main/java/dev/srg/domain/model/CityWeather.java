package dev.srg.domain.model;

import lombok.ToString;

import java.util.Objects;

@ToString
public final class CityWeather {

    private final CityName cityName;
    private final CountryCode countryCode;
    private final Temperature temperature;
    private final Clouds clouds;
    private final WeatherDate weatherDate;
    private final IssuedOn issuedOn;

    private CityWeather(Builder builder) {
        Guards.notNull(builder.cityName, "City Name cannot be null");
        Guards.notNull(builder.countryCode, "Country Code cannot be null");
        Guards.notNull(builder.temperature, "Temperature cannot be null");
        Guards.notNull(builder.clouds, "Clouds cannot be null");
        Guards.notNull(builder.weatherDate, "Weather Date cannot be null");
        Guards.notNull(builder.issuedOn, "IssuedOn cannot be null");

        this.cityName = builder.cityName;
        this.countryCode = builder.countryCode;
        this.temperature = builder.temperature;
        this.clouds = builder.clouds;
        this.weatherDate = builder.weatherDate;
        this.issuedOn = builder.issuedOn;
    }

    public CityName getCityName() {
        return cityName;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public WeatherDate getWeatherDate() {
        return weatherDate;
    }

    public IssuedOn getIssuedOn() {
        return issuedOn;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CityWeather that = (CityWeather) o;
        return Objects.equals(cityName, that.cityName) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(clouds, that.clouds) &&
                Objects.equals(weatherDate, that.weatherDate) &&
                Objects.equals(issuedOn, that.issuedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, countryCode, temperature, clouds, weatherDate, issuedOn);
    }

    public static class Builder {

        private CityName cityName;
        private CountryCode countryCode;
        private Temperature temperature;
        private Clouds clouds;
        private WeatherDate weatherDate;
        private IssuedOn issuedOn;

        public Builder withCityName(CityName cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder withCountryCode(CountryCode countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder withTemperature(Temperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withClouds(Clouds clouds) {
            this.clouds = clouds;
            return this;
        }

        public Builder withWeatherDate(WeatherDate weatherDate) {
            this.weatherDate = weatherDate;
            return this;
        }

        public Builder withIssuedOn(IssuedOn issuedOn) {
            this.issuedOn = issuedOn;
            return this;
        }

        public CityWeather build() {
            return new CityWeather(this);
        }
    }
}
