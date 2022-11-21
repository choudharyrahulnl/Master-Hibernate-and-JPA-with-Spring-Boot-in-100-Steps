package com.digitalaicloud.hibernate.controller;

import com.digitalaicloud.hibernate.config.CurrencyServiceConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-configuration")
public class CurrencyConfigurationController {

    private CurrencyServiceConfiguration currencyServiceConfiguration;

    public CurrencyConfigurationController(CurrencyServiceConfiguration currencyServiceConfiguration) {
        this.currencyServiceConfiguration = currencyServiceConfiguration;
    }

    @GetMapping
    public CurrencyServiceConfiguration getAllCourses() {
        return currencyServiceConfiguration;
    }
}
