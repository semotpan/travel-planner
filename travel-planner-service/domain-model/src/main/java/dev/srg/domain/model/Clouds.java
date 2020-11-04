package dev.srg.domain.model;

import lombok.ToString;

import java.util.Objects;

@ToString
public final class Clouds {

    private final Integer value;
    private final Unit unit;

    private Clouds(Integer value, Unit unit) {
        Guards.notNull(value, "The value must not be null");
        Guards.notNull(unit, "The unit must not be null");
        this.value = value;
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public static Clouds valueOf(Integer value, Unit unit) {
        return new Clouds(value, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Clouds clouds = (Clouds) o;
        return Objects.equals(value, clouds.value) &&
                unit == clouds.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public enum Unit {
        PERCENTAGE
    }
}
