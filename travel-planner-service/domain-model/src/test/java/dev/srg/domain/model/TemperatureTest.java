package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static dev.srg.domain.model.Temperature.Unit.CELSIUS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class TemperatureTest {

    @Test
    void creation() {
        assertThat(Temperature.valueOf(1.0, CELSIUS))
                .isNotNull()
                .isEqualTo(Temperature.valueOf(1.0, CELSIUS));
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Temperature.valueOf(null, CELSIUS))
                .withMessage("The value must not be null");
    }

    @Test
    void creationFailsWhenUnitIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Temperature.valueOf(1.0, null))
                .withMessage("The unit must not be null");
    }
}