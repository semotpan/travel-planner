package dev.srg.domain.model;

import lombok.ToString;

import java.util.Objects;

@ToString
public final class Temperature {

    private final Double value;
    private final Unit unit;

    private Temperature(Double value, Unit unit) {
        Guards.notNull(value, "The value must not be null");
        Guards.notNull(unit, "The unit must not be null");

        this.value = value;
        this.unit = unit;
    }

    public static Temperature valueOf(Double value, Unit unit) {
        return new Temperature(value, unit);
    }

    public Double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Temperature that = (Temperature) o;
        return Objects.equals(value, that.value) &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public enum Unit {
        CELSIUS
    }
}
