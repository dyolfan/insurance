package com.kputimcevs.insurance.controllers;

import com.kputimcevs.insurance.premium.domain.PremiumResponse;
import com.kputimcevs.insurance.premium.entities.policy.Policy;
import com.kputimcevs.insurance.premium.services.PremiumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PremiumControllerTest {
    @Mock
    private PremiumService premiumService;
    @InjectMocks
    private PremiumController controller;

    @Test
    public void getPremiumByPolicyReturnsValueFromService() {
        Policy policy = mock(Policy.class);
        PremiumResponse premiumResponse = mock(PremiumResponse.class);
        when(premiumService.getPremiumForPolicy(policy)).thenReturn(premiumResponse);

        PremiumResponse response = controller.getPremiumByPolicy(policy);

        assertEquals(premiumResponse, response);
    }
}