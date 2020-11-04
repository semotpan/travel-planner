package dev.srg.domain.model;

import java.time.Instant;
import java.util.Objects;

public final class WeatherDateTime {

    private final Instant value;

    private WeatherDateTime(Instant value) {
        Guards.notNull(value, "The value must not be null");
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }

    public static WeatherDateTime valueOf(Instant value) {
        return new WeatherDateTime(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        WeatherDateTime that = (WeatherDateTime) o;
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
