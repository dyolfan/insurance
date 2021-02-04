package com.kputimcevs.insurance;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtils {
    public static void assertReflEquals(Object actual, Object expected) {
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
