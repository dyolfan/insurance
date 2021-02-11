package com.kputimcevs.insurance.premium.entities;

public enum ThresholdOperator {
    ABOVE,
    ABOVE_OR_EQUAL;

    public boolean isAboveThreshold(double sum, double threshold) {
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
