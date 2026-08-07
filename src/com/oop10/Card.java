package com.oop10;

public class Card {


    private String cardName;
    int number;

    public Card(String cardName) {
        this.cardName = cardName;

        this.number = Company.cardSerialNumber;
        Company.cardSerialNumber++;


    }
}
