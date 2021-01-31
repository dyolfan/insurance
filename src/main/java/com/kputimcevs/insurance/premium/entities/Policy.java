package com.kputimcevs.insurance.premium.entities;

import java.util.ArrayList;
import java.util.List;

public class Policy {
    public String policyNumber;
    public PolicyStatus policyStatus;
    public List<PolicyObjects> policyObjects = new ArrayList<>();

    public static class PolicyObjects {
        public String objectName;
        public List<SubObject> subObjects = new ArrayList<>();
    }

    public static class SubObject {
        public String subObjectName;
        public float sumInsured;
        public RiskType riskType;
    }
}
