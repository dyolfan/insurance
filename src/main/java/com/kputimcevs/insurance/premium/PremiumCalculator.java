package com.kputimcevs.insurance.premium;

import com.kputimcevs.insurance.premium.entities.Policy;
import org.springframework.stereotype.Component;

@Component
public class PremiumCalculator {

    public String calculate(Policy policy) {
        return "0 EUR";
    }
}
