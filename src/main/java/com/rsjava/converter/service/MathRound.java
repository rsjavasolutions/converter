package com.rsjava.converter.service;

public final class MathRound {

    public static final double GET_ROUNDED_NUMBER_TO_FOUR_DECIMAL_PLACES(double value){
        value *= 10000;
        value = Math.round(value);
        value /= 10000;
        return value;
    }
}
