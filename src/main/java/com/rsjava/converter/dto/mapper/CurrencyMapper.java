package com.rsjava.converter.dto.mapper;

import com.rsjava.converter.dto.CurrencyDto;
import com.rsjava.converter.model.Rate;
import com.rsjava.converter.service.MathRound;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {

    private CurrencyDto mapToCurrencyDto(Rate rate){
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setCurrency(rate.getCurrency());
        currencyDto.setCode(rate.getCode());
        currencyDto.setValue(MathRound.GET_ROUNDED_NUMBER_TO_FOUR_DECIMAL_PLACES(rate.getMid()));
        return currencyDto;
    }

    public List<CurrencyDto> mapToListCurrencyDto(List<Rate> rateList){
        return rateList.stream()
                .map(currency -> mapToCurrencyDto(currency))
                .collect(Collectors.toList());
    }
}
