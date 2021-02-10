package com.kputimcevs.insurance.premium.entities;

import com.kputimcevs.insurance.premium.risktype.processors.CataclysmRiskTypeProcessor;
import com.kputimcevs.insurance.premium.risktype.processors.IRiskTypeProcessor;
import com.kputimcevs.insurance.premium.risktype.processors.ThresholdRiskTypeProcessor;

public enum RiskType {
    FIRE(ThresholdRiskTypeProcessor.class),
    THEFT(ThresholdRiskTypeProcessor.class),
    VOLCANO(CataclysmRiskTypeProcessor.class),
    SINKING(ThresholdRiskTypeProcessor.class);

    public Class<? extends IRiskTypeProcessor> riskTypeProcessor;

    RiskType(Class<? extends IRiskTypeProcessor> riskTypeProcessor) {
        this.riskTypeProcessor = riskTypeProcessor;
    }
}
