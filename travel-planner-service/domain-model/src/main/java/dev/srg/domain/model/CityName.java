package dev.srg.domain.model;

import java.util.Objects;

public final class CityName {

    private final String value;

    private CityName(String value) {
        Guards.notNull(value, "The value must not be null");
        Guards.notBlank(value, "The value must not be blank");
        this.value = value;
    }

    public static CityName valueOf(String value) {
        return new CityName(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CityName cityName = (CityName) o;
        return Objects.equals(value, cityName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
