package dev.srg.domain.model;

import lombok.ToString;

import java.util.List;
import java.util.Objects;

@ToString
public final class Itinerary {

    private final ItineraryName name;
    private final List<CityWeather> citiesItinerary;

    public Itinerary(ItineraryName name, List<CityWeather> citiesItinerary) {
        Guards.notNull(name, "The Itinerary Name cannot be null");
        Guards.notEmpty(citiesItinerary, "The Cities Itinerary cannot be empty");
        this.name = name;
        this.citiesItinerary = citiesItinerary;
    }

    public static Itinerary valueOf(ItineraryName name, List<CityWeather> citiesItinerary) {
        return new Itinerary(name, citiesItinerary);
    }

    public ItineraryName getName() {
        return name;
    }

    public List<CityWeather> getCitiesItinerary() {
        return citiesItinerary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Itinerary itinerary = (Itinerary) o;
        return Objects.equals(name, itinerary.name) &&
                Objects.equals(citiesItinerary, itinerary.citiesItinerary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, citiesItinerary);
    }
}
