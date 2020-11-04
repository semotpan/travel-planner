package dev.srg.domain.model;

import java.util.Objects;

public final class ItineraryName {

    private final String value;

    private ItineraryName(String value) {
        Guards.notNull(value, "The value must not be null");
        Guards.notBlank(value, "The value must not be blank");
        this.value = value;
    }

    public static ItineraryName valueOf(String value) {
        return new ItineraryName(value);
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

        ItineraryName that = (ItineraryName) o;
        return Objects.equals(value, that.value);
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
