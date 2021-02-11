package com.kputimcevs.insurance.premium.risktype.processors;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.ThresholdOperator;

import java.util.Arrays;
import java.util.List;

import static com.kputimcevs.insurance.premium.entities.RiskType.FIRE;
import static com.kputimcevs.insurance.premium.entities.RiskType.SINKING;
import static com.kputimcevs.insurance.premium.entities.RiskType.THEFT;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;

enum BasicThreshold {
    DEFAULT_ABOVE_THRESHOLD(100, ABOVE, 0.014, 0.024, List.of(FIRE, SINKING)),
    DEFAULT_ABOVE_OR_EQUAL_THRESHOLD(15, ABOVE_OR_EQUAL, 0.11, 0.05, List.of(THEFT));

    public final double thresholdValue;
    public final double averageCoefficient;
    public final double aboveThresholdCoefficient;
    public final ThresholdOperator thresholdOperator;
    public final List<RiskType> riskTypes;

    BasicThreshold(int thresholdValue, ThresholdOperator thresholdOperator, double averageCoefficient, double aboveThresholdCoefficient, List<RiskType> riskTypes) {
        this.thresholdValue = thresholdValue;
        this.averageCoefficient = averageCoefficient;
        this.aboveThresholdCoefficient = aboveThresholdCoefficient;
        this.thresholdOperator = thresholdOperator;
        this.riskTypes = riskTypes;
    }

    public static BasicThreshold resolveThresholdFromRiskType(RiskType riskType) {
        return Arrays.stream(BasicThreshold.values()).filter(t -> t.riskTypes.contains(riskType)).findFirst().orElseThrow();
    }
}
