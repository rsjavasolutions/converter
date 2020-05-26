package com.rsjava.converter.dto.mapper;

import com.rsjava.converter.dto.CurrencyDto;
import com.rsjava.converter.model.Rate;
import com.rsjava.converter.service.MathRound;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {

    private CurrencyDto mapToCurrencyDto(Rate rate){
        return new CurrencyDto(
                rate.getCode(),
                rate.getCurrency(),
                MathRound.GET_ROUNDED_NUMBER_TO_FOUR_DECIMAL_PLACES(
                        rate.getMid().doubleValue()
                ));
    }

    public List<CurrencyDto> mapToListCurrencyDto(List<Rate> rateList){
        return rateList.stream()
                .map(currency -> mapToCurrencyDto(currency))
                .collect(Collectors.toList());
    }
}
