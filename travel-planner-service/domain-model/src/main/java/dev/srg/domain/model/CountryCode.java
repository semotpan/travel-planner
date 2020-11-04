package dev.srg.domain.model;

import lombok.ToString;

import java.util.Objects;

@ToString
public final class CountryCode {

    private final String value;

    public CountryCode(String value) {
        Guards.notNull(value, "The value must not be null");
        Guards.notBlank(value, "The value must not be blank");
        this.value = value;
    }

    public static CountryCode valueOf(String value) {
        return new CountryCode(value);
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

        CountryCode that = (CountryCode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
