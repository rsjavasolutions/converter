package com.rsjava.converter.service;

import com.rsjava.converter.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConverter {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyConverter(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public double convert(Transaction transaction){
        double divider = currencyService.getValueByCode(transaction.getFrom());
        double divident = currencyService.getValueByCode(transaction.getTo());
        return transaction.getAmount() * (divider / divident);
    }

}
