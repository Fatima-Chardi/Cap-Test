package com.test.corebanking.enums;

public enum TransactionType {
    CREDIT("Credit"),
    DEBIT("Debit");

    public final String value;

    TransactionType(String value){
        this.value=value;
    }
}
