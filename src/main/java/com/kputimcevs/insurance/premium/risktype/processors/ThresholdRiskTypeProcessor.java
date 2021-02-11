package com.kputimcevs.insurance.premium.risktype.processors;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ThresholdRiskTypeProcessor implements IRiskTypeProcessor {
    public double process(Policy policy, RiskType riskType) {
        Map<RiskType, Double> subObjectsRiskMap = getSubObjectsRiskTypesMap(policy, riskType);

        return subObjectsRiskMap.entrySet().stream().mapToDouble(this::calculatePremiumForRiskMap).sum();
    }

    private double calculatePremiumForRiskMap(Map.Entry<RiskType, Double> entry) {
        RiskType riskType = entry.getKey();
        double sum = entry.getValue();
        BasicThreshold basicThreshold = BasicThreshold.resolveThresholdFromRiskType(riskType);

        if (basicThreshold.thresholdOperator.isAboveThreshold(sum, basicThreshold.thresholdValue)) {
            return sum * basicThreshold.aboveThresholdCoefficient;
        } else {
            return sum * basicThreshold.averageCoefficient;
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

}
