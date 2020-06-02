package com.rsjava.converter.exception;

public class IncorrectCurrencyCodeException extends RuntimeException {

    public IncorrectCurrencyCodeException(String code) {
        super(code);
    }
}
