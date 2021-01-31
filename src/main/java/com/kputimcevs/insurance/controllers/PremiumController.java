package com.kputimcevs.insurance.controllers;

import com.kputimcevs.insurance.premium.dataobjects.Policy;
import com.kputimcevs.insurance.premium.domain.PremiumResponse;
import com.kputimcevs.insurance.premium.services.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/premium")
public class PremiumController {
    @Autowired
    private PremiumService premiumService;

    @GetMapping("/policy")
    public PremiumResponse getPremiumByPolicy(@RequestBody Policy policy) {
        return premiumService.getPremiumForPolicy(policy);
    }
}
