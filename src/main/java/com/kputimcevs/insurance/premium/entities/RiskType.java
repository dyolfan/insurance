package com.kputimcevs.insurance.premium.entities;

import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;

public enum RiskType {
    FIRE(100, ABOVE, 0.014f, 0.024f),
    THEFT(15, ABOVE_OR_EQUAL, 0.11f, 0.05f);

    public final float threshold;
    public final float averageCoefficient;
    public final float aboveThresholdCoefficient;
    public final ThresholdOperator thresholdOperator;

    RiskType(int threshold, ThresholdOperator thresholdOperator, float averageCoefficient, float aboveThresholdCoefficient) {
        this.threshold = threshold;
        this.averageCoefficient = averageCoefficient;
        this.aboveThresholdCoefficient = aboveThresholdCoefficient;
        this.thresholdOperator = thresholdOperator;
    }
}
