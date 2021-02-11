package com.kputimcevs.insurance.premium.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class BasicThresholdOperatorTest {
    @Test
    public void falseForAboveWhenDoesNotExceedThreshold() {
        double sum = 2.5;
        double threshold = 2.5;

        assertFalse(ABOVE.isAboveThreshold(sum, threshold));
    }

    @Test
    public void trueForAboveWhenExceedsThreshold() {
        double sum = 2.51;
        double threshold = 2.5;

        assertTrue(ABOVE.isAboveThreshold(sum, threshold));
    }

    @Test
    public void falseForAboveOrEqualWhenDoesNotExceedThreshold() {
        double sum = 2.49;
        double threshold = 2.5;

        assertFalse(ABOVE_OR_EQUAL.isAboveThreshold(sum, threshold));
    }

    @Test
    public void falseForAboveOrEqualWhenExceedsThreshold() {
        float sum = 2.5f;
        float threshold = 2.5f;

        assertTrue(ABOVE_OR_EQUAL.isAboveThreshold(sum, threshold));
    }
}