package com.kputimcevs.insurance.premium.services;

import com.kputimcevs.insurance.premium.PremiumCalculator;
import com.kputimcevs.insurance.premium.entities.Policy;
import com.kputimcevs.insurance.premium.domain.PremiumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumService {
    @Autowired
    private PremiumCalculator premiumCalculator;

    public PremiumResponse getPremiumForPolicy(Policy policy) {
        String premiumSum = premiumCalculator.calculate(policy);
        return new PremiumResponse(premiumSum);
    }
}
