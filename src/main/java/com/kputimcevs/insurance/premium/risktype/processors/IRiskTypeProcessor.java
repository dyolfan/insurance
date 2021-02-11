package com.kputimcevs.insurance.premium.risktype.processors;

import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.policy.Policy;

public interface IRiskTypeProcessor {
    double process(Policy policy, RiskType riskType);
}
