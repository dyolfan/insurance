package com.kputimcevs.insurance.premium;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kputimcevs.insurance.common.utils.MathUtil.roundTo2DecimalPositions;

@Component
public class PremiumCalculator {
    public double calculate(Policy policy) {
        Map<RiskType, Double> subObjectsRiskMap = getSubObjectsRiskTypesMap(policy);
        double result = subObjectsRiskMap.entrySet().stream().mapToDouble(this::calculatePremiumForRiskMap).sum();

        return roundTo2DecimalPositions(result);
    }

    private Map<RiskType, Double> getSubObjectsRiskTypesMap(Policy policy) {
        return policy.policyObjects.stream()
                .map(po -> po.subObjects)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.toMap(subObj -> subObj.riskType, subObj -> subObj.sumInsured, Double::sum)
                );
    }

    private double calculatePremiumForRiskMap(Map.Entry<RiskType, Double> entry) {
        RiskType riskType = entry.getKey();
        double sum = entry.getValue();

        if (riskType.thresholdOperator.isAboveThreshold(sum, riskType.threshold)) {
            return sum * riskType.aboveThresholdCoefficient;
        } else {
            return sum * riskType.averageCoefficient;
        }
    }
}
