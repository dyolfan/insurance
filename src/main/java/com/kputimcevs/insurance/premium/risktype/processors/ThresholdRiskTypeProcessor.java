package com.kputimcevs.insurance.premium.risktype.processors;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.ThresholdOperator;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kputimcevs.insurance.premium.entities.RiskType.FIRE;
import static com.kputimcevs.insurance.premium.entities.RiskType.SINKING;
import static com.kputimcevs.insurance.premium.entities.RiskType.THEFT;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE;
import static com.kputimcevs.insurance.premium.entities.ThresholdOperator.ABOVE_OR_EQUAL;

@Component
public class ThresholdRiskTypeProcessor implements IRiskTypeProcessor {
    public double process(Policy policy, RiskType riskType) {
        Map<RiskType, Double> subObjectsRiskMap = getSubObjectsRiskTypesMap(policy, riskType);

        return subObjectsRiskMap.entrySet().stream().mapToDouble(this::calculatePremiumForRiskMap).sum();
    }

    private double calculatePremiumForRiskMap(Map.Entry<RiskType, Double> entry) {
        RiskType riskType = entry.getKey();
        double sum = entry.getValue();
        Threshold threshold = Threshold.resolveThresholdFromRiskType(riskType);

        if (threshold.thresholdOperator.isAboveThreshold(sum, threshold.thresholdValue)) {
            return sum * threshold.aboveThresholdCoefficient;
        } else {
            return sum * threshold.averageCoefficient;
        }
    }

    private Map<RiskType, Double> getSubObjectsRiskTypesMap(Policy policy, RiskType riskType) {
        return policy.policyObjects.stream()
                .map(po -> po.subObjects)
                .flatMap(Collection::stream)
                .filter(so -> so.riskType == riskType)
                .collect(
                        Collectors.toMap(subObj -> subObj.riskType, subObj -> subObj.sumInsured, Double::sum)
                );
    }

    private enum Threshold {
        DEFAULT_ABOVE_THRESHOLD(100, ABOVE, 0.014, 0.024, List.of(FIRE, SINKING)),
        DEFAULT_ABOVE_OR_EQUAL_THRESHOLD(15, ABOVE_OR_EQUAL, 0.11, 0.05, List.of(THEFT));

        public final double thresholdValue;
        public final double averageCoefficient;
        public final double aboveThresholdCoefficient;
        public final ThresholdOperator thresholdOperator;
        public final List<RiskType> riskTypes;

        Threshold(int thresholdValue, ThresholdOperator thresholdOperator, double averageCoefficient, double aboveThresholdCoefficient, List<RiskType> riskTypes) {
            this.thresholdValue = thresholdValue;
            this.averageCoefficient = averageCoefficient;
            this.aboveThresholdCoefficient = aboveThresholdCoefficient;
            this.thresholdOperator = thresholdOperator;
            this.riskTypes = riskTypes;
        }

        public static Threshold resolveThresholdFromRiskType(RiskType riskType) {
            return Arrays.stream(Threshold.values()).filter(t -> t.riskTypes.contains(riskType)).findFirst().orElseThrow();
        }
    }
}
