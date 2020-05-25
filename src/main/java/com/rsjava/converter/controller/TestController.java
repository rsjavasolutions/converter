package com.rsjava.converter.controller;


import com.rsjava.converter.model.nbpapi.Rate;
import com.rsjava.converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private CurrencyService currencyService;

    @Autowired
    public TestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currencies")
    public List<Rate> getCurrencies(){
        return currencyService.getAllCurrencies();
    }
}
