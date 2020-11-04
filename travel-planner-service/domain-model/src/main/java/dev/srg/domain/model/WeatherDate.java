package dev.srg.domain.model;

import java.time.Instant;
import java.util.Objects;

public final class WeatherDate {

    private final Instant value;

    private WeatherDate(Instant value) {
        Guards.notNull(value, "The value must not be null");
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }

    public static WeatherDate valueOf(Instant value) {
        return new WeatherDate(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        WeatherDate that = (WeatherDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
