package com.kputimcevs.insurance.premium.services;

import com.kputimcevs.insurance.premium.PremiumCalculator;
import com.kputimcevs.insurance.premium.domain.PremiumResponse;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kputimcevs.insurance.TestUtils.assertReflEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PremiumServiceTest {
    @Mock
    private PremiumCalculator premiumCalculator;
    @InjectMocks
    private PremiumService premiumService;

    @Test
    public void getPremiumForPolicyReturnsPremiumResponse() {
        float premium = 10.56f;
        Policy policy = mock(Policy.class);
        when(premiumCalculator.calculate(policy)).thenReturn(premium);

        PremiumResponse expectedResponse = new PremiumResponse(premium + " EUR");
        PremiumResponse premiumResponse = premiumService.getPremiumForPolicy(policy);
        assertReflEquals(premiumResponse, expectedResponse);
    }
}