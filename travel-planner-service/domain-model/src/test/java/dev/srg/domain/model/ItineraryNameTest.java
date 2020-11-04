package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Tag("unit")
class ItineraryNameTest {

    @Test
    void creation() {
        String name = "itinerary";

        assertThat(ItineraryName.valueOf(name))
                .isNotNull()
                .extracting(ItineraryName::getValue)
                .isEqualTo(name);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> ItineraryName.valueOf(null))
                .withMessage("The value must not be null");
    }

    @Test
    void creationFailsWhenValueIsEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ItineraryName.valueOf(""))
                .withMessage("The value must not be blank");
    }
}