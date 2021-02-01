package com.kputimcevs.insurance.premium.entities;

public enum ThresholdOperator {
    ABOVE,
    ABOVE_OR_EQUAL;

    public boolean isAboveThreshold(float v1, float v2) {
        switch (this) {
            case ABOVE:
                return v1 > v2;
            case ABOVE_OR_EQUAL:
                return v1 >= v2;
            default:
                return false;
        }
    }
}
