package com.rsjava.converter.dto.mapper;

import com.rsjava.converter.dto.CurrencyDto;
import com.rsjava.converter.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {

    public CurrencyDto mapToCurrencyDto(Rate rate){
        return new CurrencyDto(
                rate.getCode(),
                rate.getCurrency(),
                getRoundedNumberToFourDecimalPlaces(rate.getMid().doubleValue()));
    }

    public List<CurrencyDto> mapToListCurrencyDto(List<Rate> rateList){
        return rateList.stream()
                .map(currency -> mapToCurrencyDto(currency))
                .collect(Collectors.toList());
    }

    private double getRoundedNumberToFourDecimalPlaces(double value){
        value *= 10000;
        value = Math.round(value);
        value /= 10000;
        return value;
    }
}
