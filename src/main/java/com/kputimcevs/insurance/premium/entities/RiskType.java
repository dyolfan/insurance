package com.kputimcevs.insurance.premium.entities;

import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;

public enum RiskType {
    FIRE(100, ABOVE, (float) 0.014, (float) 0.028),
    THEFT(15, ABOVE_OR_EQUAL, (float) 0.11, (float) 0.05);

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
