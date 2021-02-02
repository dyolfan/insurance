package com.kputimcevs.insurance.premium.entities.policy;

import com.kputimcevs.insurance.premium.entities.PolicyStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Policy {
    @NotBlank
    public String policyNumber;
    @NotNull
    public PolicyStatus policyStatus;
    @Valid
    public List<PolicyObject> policyObjects = new ArrayList<>();
    
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }
}
