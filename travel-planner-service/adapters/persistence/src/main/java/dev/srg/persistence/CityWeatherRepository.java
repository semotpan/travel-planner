package dev.srg.persistence;

import org.springframework.data.repository.CrudRepository;

public interface CityWeatherRepository extends CrudRepository<CityWeatherTable, Long> {
}
