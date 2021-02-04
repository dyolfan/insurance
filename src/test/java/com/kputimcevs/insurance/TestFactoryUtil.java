package com.kputimcevs.insurance;

import com.kputimcevs.insurance.premium.entities.PolicyStatus;
import com.kputimcevs.insurance.premium.entities.RiskType;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import com.kputimcevs.insurance.premium.entities.policy.PolicyObject;
import com.kputimcevs.insurance.premium.entities.policy.SubObject;

import java.util.List;

public class TestFactoryUtil {
    public static Policy createPolicy() {
        return createPolicy(List.of(
                createPolicyObject("House", List.of(
                        createPolicySubObject("TV", RiskType.FIRE, (float) 20.49),
                        createPolicySubObject("Clock", RiskType.THEFT, (float) 2.48),
                        createPolicySubObject("Stereo System", RiskType.FIRE, (float) 25.51)
                )),
                createPolicyObject("Garden", List.of(
                        createPolicySubObject("Trimmer", RiskType.THEFT, (float) 2),
                        createPolicySubObject("Treehouse", RiskType.FIRE, (float) 54),
                        createPolicySubObject("Snow machine", RiskType.THEFT, (float) 3.52)
                ))
        ));
    }

    public static Policy createPolicy(List<PolicyObject> policyObjects) {
        Policy policy = new Policy();
        policy.policyNumber = "Test-policy-1";
        policy.policyStatus = PolicyStatus.APPROVED;
        policy.policyObjects = policyObjects;

        return policy;
    }

    public static PolicyObject createPolicyObject(String objectName, List<SubObject> subObjects) {
        PolicyObject policyObject = new PolicyObject();
        policyObject.objectName = objectName;
        policyObject.subObjects = subObjects;

        return policyObject;
    }

    public static SubObject createPolicySubObject(String subObjectName, RiskType riskType, float sumInsured) {
        SubObject subObject = new SubObject();
        subObject.subObjectName = subObjectName;
        subObject.riskType = riskType;
        subObject.sumInsured = sumInsured;

        return subObject;
    }
}
