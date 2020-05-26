package com.rsjava.converter.controller;

import com.rsjava.converter.dto.CurrencyCodeDto;
import com.rsjava.converter.dto.CurrencyDto;
import com.rsjava.converter.dto.mapper.CurrencyCodeDtoMapper;
import com.rsjava.converter.dto.mapper.CurrencyMapper;
import com.rsjava.converter.model.Rate;
import com.rsjava.converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CurrencyController {

    private CurrencyService currencyService;
    private CurrencyMapper currencyMapper;
    private CurrencyCodeDtoMapper currencyCodeDtoMapper;

    @Autowired
    public CurrencyController(
            CurrencyService currencyService, CurrencyMapper currencyMapper,
            CurrencyCodeDtoMapper currencyCodeDtoMapper) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
        this.currencyCodeDtoMapper = currencyCodeDtoMapper;

    }

    @GetMapping("currencies")
    public List<CurrencyDto> getAllCurrencies(){
        return currencyMapper.mapToListCurrencyDto(currencyService.getAllRates());
    }

    @GetMapping("currencies/codes")
    public List<CurrencyCodeDto> getAllCurrenciesCodes (){
        return currencyCodeDtoMapper.mapToListCurrencyCodeDto(currencyService.getAllRates());
    }
}
