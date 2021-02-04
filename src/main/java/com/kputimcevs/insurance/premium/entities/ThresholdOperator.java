package com.kputimcevs.insurance.premium.entities;

public enum ThresholdOperator {
    ABOVE,
    ABOVE_OR_EQUAL;

    public boolean isAboveThreshold(float sum, float threshold) {
        switch (this) {
            case ABOVE:
                return sum > threshold;
            case ABOVE_OR_EQUAL:
                return sum >= threshold;
            default:
                return false;
        }
    }
}
