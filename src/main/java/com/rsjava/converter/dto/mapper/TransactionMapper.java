package com.rsjava.converter.dto.mapper;

import com.rsjava.converter.dto.TransactionDto;
import com.rsjava.converter.model.Transaction;
import com.rsjava.converter.service.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private CurrencyConverter currencyConverter;

    @Autowired
    public TransactionMapper(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction){
       return new TransactionDto(
               transaction.getAmount(),
               transaction.getFrom(),
               transaction.getTo(),
               currencyConverter.convert(
                       transaction
               ));
    }
}
