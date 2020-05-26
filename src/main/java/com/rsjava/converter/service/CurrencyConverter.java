package com.rsjava.converter.service;

import com.rsjava.converter.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dom.DOMCryptoContext;

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
        double amount = transaction.getAmount();

        if (0 >= amount){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        return MathRound.GET_ROUNDED_NUMBER_TO_FOUR_DECIMAL_PLACES(
                amount * (divider / divident));
    }
}
