package dev.srg.domain.model;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public final class Guards {

    private Guards() {
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    public static void notBlank(String text, String message) {
        if (isBlank(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(List<?> values, String message) {
        if (values == null || values.size() == 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
