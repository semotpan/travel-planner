package dev.srg.domain.model;

import java.util.List;

public interface CityWeathers {

    void save(CityWeather cityWeather);

    List<CityWeather> find(CityName cityName);
}
