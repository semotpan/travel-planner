package dev.srg.domain.model;

import java.time.Instant;
import java.util.Objects;

public final class IssuedOn {

    private final Instant value;

    private IssuedOn(Instant value) {
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }

    public static IssuedOn newValue() {
        return new IssuedOn(Instant.now());
    }
    public static IssuedOn valueOf(Instant value) {
        return new IssuedOn(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        IssuedOn that = (IssuedOn) o;
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
