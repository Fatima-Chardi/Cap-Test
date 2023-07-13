package com.test.corebanking.enums;

public enum TransactionType {
    C("Credit"),
    D("Debit");

    public final String value;

    TransactionType(String value){
        this.value=value;
    }
}
