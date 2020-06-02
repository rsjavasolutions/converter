package com.rsjava.converter.service;

import com.rsjava.converter.exception.NullInputDataException;
import com.rsjava.converter.model.Transaction;
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
        if (isAnyOfInIncomingDataIsNull(transaction)){
            throw  new NullInputDataException();
        }
        double divider = currencyService.getValueByCode(transaction.getFrom());
        double divident = currencyService.getValueByCode(transaction.getTo());
        double amount = transaction.getAmount();

        if (0 >= amount){
            throw new IllegalArgumentException("AMOUNT MUST BE GREATER THAN ZERO");
        }
        return MathRound.GET_ROUNDED_NUMBER_TO_FOUR_DECIMAL_PLACES(
                amount * (divider / divident));
    }

    private boolean isAnyOfInIncomingDataIsNull(Transaction transaction){
        return (transaction.getAmount() == null ||
                transaction.getFrom() == null ||
                transaction.getTo() == null);
    }

}
