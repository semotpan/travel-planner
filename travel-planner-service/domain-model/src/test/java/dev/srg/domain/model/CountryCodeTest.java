package dev.srg.domain.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Tag("unit")
class CountryCodeTest {

    @Test
    void creation() {
        String md = "MD";

        assertThat(CountryCode.valueOf(md))
                .isNotNull()
                .extracting(CountryCode::getValue)
                .isEqualTo(md);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> CountryCode.valueOf(null))
                .withMessage("The value must not be null");
    }

    @Test
    void creationFailsWhenValueIsEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CountryCode.valueOf(""))
                .withMessage("The value must not be blank");
    }
}