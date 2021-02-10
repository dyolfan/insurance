package com.kputimcevs.insurance.premium.risktype.processors;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import com.kputimcevs.insurance.premium.entities.policy.SubObject;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.kputimcevs.insurance.premium.entities.RiskType.VOLCANO;

@Component
public class CataclysmRiskTypeProcessor implements IRiskTypeProcessor {
    private static final int THRESHOLD = 100;
    private static final int THRESHOLD_2 = 250;
    private static final double DEFAULT_COEFFICIENT = 0.13;
    private static final double COEFFICIENT = 0.2;
    private static final double COEFFICIENT_2 = 0.3;

    @Override
    public double process(Policy policy, RiskType riskType) {
        List<SubObject> subObjects = policy.policyObjects.stream().map(po -> po.subObjects).flatMap(Collection::stream).filter(po -> po.riskType == VOLCANO).collect(Collectors.toList());

        double sum = 0;
        for (var subObject : subObjects) {
            sum += subObject.sumInsured;
        }

        return multiplyOnCoefficient(sum / subObjects.size());
    }

    private double multiplyOnCoefficient(double average) {
        if (average > THRESHOLD_2) {
            return average * COEFFICIENT_2;
        }
        if (average > THRESHOLD) {
            return average * COEFFICIENT;
        }

        return average * DEFAULT_COEFFICIENT;
    }
}
