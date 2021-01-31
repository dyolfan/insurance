package com.kputimcevs.insurance.premium;

import com.kputimcevs.insurance.premium.entities.Policy;
import com.kputimcevs.insurance.premium.entities.RiskType;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kputimcevs.insurance.common.utils.MathUtil.roundTo2DecimalPositions;

@Component
public class PremiumCalculator {

    private double sumRiskMap(Map.Entry<RiskType, Float> entry) {
        RiskType riskType = entry.getKey();
        float sum = entry.getValue();

        // TODO: add threshold coefficients logic
        return sum;
    }

    public String calculate(Policy policy) {
        Map<RiskType, Float> subObjectsRiskMap = getSubObjectsRiskTypesMap(policy);
        float result = (float) subObjectsRiskMap.entrySet().stream().mapToDouble(this::sumRiskMap).sum();

        return roundTo2DecimalPositions(result) + " EUR";
    }

    private Map<RiskType, Float> getSubObjectsRiskTypesMap(Policy policy) {
        return policy.policyObjects.stream()
                .map(po -> po.subObjects)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.toMap(subObj -> subObj.riskType, subObj -> subObj.sumInsured, Float::sum)
                );
    }
}
