package com.kputimcevs.insurance.premium;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import com.kputimcevs.insurance.premium.risktype.processors.IRiskTypeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kputimcevs.insurance.common.utils.MathUtil.roundTo2DecimalPositions;

@Component
public class PremiumCalculator {
    @Autowired
    private ApplicationContext context;

    public double calculate(Policy policy) {
        Set<RiskType> riskTypes = policy.policyObjects.stream().map(po -> po.subObjects).flatMap(Collection::stream).map(so -> so.riskType).collect(Collectors.toSet());

        double policyPremium = 0;

        for (var riskType : riskTypes) {
            IRiskTypeProcessor riskTypeProcessor = context.getBean(riskType.riskTypeProcessor);
            policyPremium += riskTypeProcessor.process(policy, riskType);
        }

        return roundTo2DecimalPositions(policyPremium);
    }
}
