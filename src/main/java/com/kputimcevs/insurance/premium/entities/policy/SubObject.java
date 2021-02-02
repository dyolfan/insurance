package com.kputimcevs.insurance.premium.entities.policy;

import com.kputimcevs.insurance.premium.entities.RiskType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class SubObject {
    @NotBlank
    public String subObjectName;
    @PositiveOrZero
    public float sumInsured;
    @NotNull
    public RiskType riskType;

    public String getSubObjectName() {
        return subObjectName;
    }

    public void setSubObjectName(String subObjectName) {
        this.subObjectName = subObjectName;
    }

    public float getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(float sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }
}
