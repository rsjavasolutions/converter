package com.rsjava.converter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CurrencyDto {

    private String code;
    private String currency;
    private Double value;

}
