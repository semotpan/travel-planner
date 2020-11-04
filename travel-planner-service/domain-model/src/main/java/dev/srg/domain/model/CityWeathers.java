package dev.srg.domain.model;

import java.util.List;

public interface CityWeathers {

    void save(List<CityWeather> cityWeathers);

    List<CityWeather> find(CityName cityName);
}
