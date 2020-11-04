package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static dev.srg.domain.model.Clouds.Unit.PERCENTAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class CloudsTest {

    @Test
    void creation() {
        assertThat(Clouds.valueOf(1, PERCENTAGE))
                .isNotNull()
                .isEqualTo(Clouds.valueOf(1, PERCENTAGE));
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Clouds.valueOf(null, PERCENTAGE))
                .withMessage("The value must not be null");
    }

    @Test
    void creationFailsWhenUnitIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Clouds.valueOf(1, null))
                .withMessage("The unit must not be null");
    }
}