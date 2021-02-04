package com.kputimcevs.insurance.premium.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ThresholdOperatorTest {
    @Test
    public void falseForAboveWhenDoesNotExceedThreshold() {
        float sum = (float) 2.5;
        float threshold = (float) 2.5;

        assertFalse(ABOVE.isAboveThreshold(sum, threshold));
    }

    @Test
    public void trueForAboveWhenExceedsThreshold() {
        float sum = (float) 2.51;
        float threshold = (float) 2.5;

        assertTrue(ABOVE.isAboveThreshold(sum, threshold));
    }

    @Test
    public void falseForAboveOrEqualWhenDoesNotExceedThreshold() {
        float sum = (float) 2.49;
        float threshold = (float) 2.5;

        assertFalse(ABOVE_OR_EQUAL.isAboveThreshold(sum, threshold));
    }

    @Test
    public void falseForAboveOrEqualWhenExceedsThreshold() {
        float sum = (float) 2.5;
        float threshold = (float) 2.5;

        assertTrue(ABOVE_OR_EQUAL.isAboveThreshold(sum, threshold));
    }
}