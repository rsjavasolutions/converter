package com.rsjava.converter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private double amount;
    private String from;
    private String to;

}
