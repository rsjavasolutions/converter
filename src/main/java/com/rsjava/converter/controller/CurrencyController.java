package com.rsjava.converter.controller;

import com.rsjava.converter.dto.CurrencyCodeDto;
import com.rsjava.converter.dto.CurrencyDto;
import com.rsjava.converter.dto.TransactionDto;
import com.rsjava.converter.dto.mapper.CurrencyCodeMapper;
import com.rsjava.converter.dto.mapper.CurrencyMapper;
import com.rsjava.converter.dto.mapper.TransactionMapper;
import com.rsjava.converter.model.Transaction;
import com.rsjava.converter.service.CurrencyService;
import com.rsjava.converter.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class CurrencyController {

    private CurrencyService currencyService;
    private CurrencyMapper currencyMapper;
    private CurrencyCodeMapper currencyCodeMapper;
    private TransactionMapper transactionMapper;
    private LogService logService;

    @Autowired
    public CurrencyController(
            CurrencyService currencyService,
            CurrencyMapper currencyMapper,
            CurrencyCodeMapper currencyCodeMapper,
            TransactionMapper transactionMapper,
            LogService logService) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
        this.currencyCodeMapper = currencyCodeMapper;
        this.transactionMapper = transactionMapper;
        this.logService = logService;
    }

    @GetMapping("currencies")
    public List<CurrencyDto> getAllCurrencies() {
        logService.createGetAllCurrenciesLog();
        return currencyMapper.mapToListCurrencyDto(currencyService.getAllRates());
    }

    @GetMapping("currencies/codes")
    public List<CurrencyCodeDto> getAllCurrenciesCodes() {
        logService.createGetAllCurrenciesCodesLog();
        return currencyCodeMapper.mapToListCurrencyCodeDto(currencyService.getAllRates());
    }

    @PostMapping("currencies/convert")
    public TransactionDto convert(@RequestBody Transaction transaction) {
        logService.createConvertLog(transaction);
        return transactionMapper.mapToTransactionDto(transaction);
    }
}
