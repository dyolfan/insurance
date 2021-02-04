package com.kputimcevs.insurance.premium;

import com.kputimcevs.insurance.premium.entities.policy.Policy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kputimcevs.insurance.TestFactoryUtil.createPolicy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PremiumCalculatorTest {
    @InjectMocks
    private PremiumCalculator premiumCalculator;

    private Policy policy;

    @BeforeEach
    public void setUp() {
        policy = createPolicy();
    }

    @Test
    public void premiumCalculatorResolvesCorrectValue() {
        float result = premiumCalculator.calculate(policy);
        float expected = (float) 2.28;
        assertEquals(expected, result);
    }

    @Test
    public void premiumCalculatorResolvesCorrectValueWhenFireRiskExceedsThreshold() {
        policy.policyObjects.get(0).subObjects.get(0).sumInsured = (float) 20.5;

        float result = premiumCalculator.calculate(policy);
        float expected = (float) 3.28;
        assertEquals(expected, result);
    }

    @Test
    public void premiumCalculatorResolvesCorrectValueWhenTheftRiskExceedsThreshold() {
        policy.policyObjects.get(0).subObjects.get(1).sumInsured = (float) 9.48;

        float result = premiumCalculator.calculate(policy);
        float expected = (float) 2.15;
        assertEquals(expected, result);
    }

    @Test
    public void premiumCalculatorResolvesCorrectValueWhenBothRisksExceedsThreshold() {
        policy.policyObjects.get(0).subObjects.get(0).sumInsured = (float) 20.5;
        policy.policyObjects.get(0).subObjects.get(1).sumInsured = (float) 9.48;

        float result = premiumCalculator.calculate(policy);
        float expected = (float) 3.15;
        assertEquals(expected, result);
    }
}