package com.rsjava.converter.exception;

public class IncorrectCurrencyCodeException extends RuntimeException {
    public IncorrectCurrencyCodeException(String code) {
        System.out.println("Invalid Currency Code : " + code);
    }
}
