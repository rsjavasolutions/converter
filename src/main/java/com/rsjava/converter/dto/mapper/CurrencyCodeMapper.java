package com.rsjava.converter.dto.mapper;

import com.rsjava.converter.dto.CurrencyCodeDto;
import com.rsjava.converter.model.Rate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyCodeMapper {

    private CurrencyCodeDto mapToCurrencyCodeDto(Rate rate){
        CurrencyCodeDto currencyCodeDto = new CurrencyCodeDto();
        currencyCodeDto.setCode(rate.getCode());
        currencyCodeDto.setCurrency(rate.getCurrency());
        return currencyCodeDto;
    }

    public List<CurrencyCodeDto> mapToListCurrencyCodeDto(List<Rate> rateList){
        return rateList.stream()
                .map(currency -> mapToCurrencyCodeDto(currency))
                .collect(Collectors.toList());
    }
}
