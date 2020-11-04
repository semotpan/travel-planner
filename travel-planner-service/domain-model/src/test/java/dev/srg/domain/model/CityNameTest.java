package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Tag("unit")
class CityNameTest {

    @Test
    void creation() {
        String moscow = "Moscow";

        assertThat(CityName.valueOf(moscow))
                .isNotNull()
                .extracting(CityName::getValue)
                .isEqualTo(moscow);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> CityName.valueOf(null))
                .withMessage("The value must not be null");
    }

    @Test
    void creationFailsWhenValueIsEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CityName.valueOf(""))
                .withMessage("The value must not be blank");
    }
}