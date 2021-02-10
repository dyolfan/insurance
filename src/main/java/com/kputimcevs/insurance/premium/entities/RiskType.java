package com.kputimcevs.insurance.premium.entities;

import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;

public enum RiskType {
    FIRE(100, ABOVE, 0.014, 0.024),
    THEFT(15, ABOVE_OR_EQUAL, 0.11, 0.05);

    public final double threshold;
    public final double averageCoefficient;
    public final double aboveThresholdCoefficient;
    public final ThresholdOperator thresholdOperator;

    RiskType(int threshold, ThresholdOperator thresholdOperator, double averageCoefficient, double aboveThresholdCoefficient) {
        this.threshold = threshold;
        this.averageCoefficient = averageCoefficient;
        this.aboveThresholdCoefficient = aboveThresholdCoefficient;
        this.thresholdOperator = thresholdOperator;
    }
}
