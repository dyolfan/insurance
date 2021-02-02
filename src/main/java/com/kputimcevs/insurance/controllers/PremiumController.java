package com.kputimcevs.insurance.controllers;

import com.kputimcevs.insurance.premium.entities.policy.Policy;
import com.kputimcevs.insurance.premium.domain.PremiumResponse;
import com.kputimcevs.insurance.premium.services.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/premium")
@Validated
public class PremiumController {
    @Autowired
    private PremiumService premiumService;

    @GetMapping("/policy")
    public PremiumResponse getPremiumByPolicy(@Valid @RequestBody Policy policy) {
        return premiumService.getPremiumForPolicy(policy);
    }
}
