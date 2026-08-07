package com.oop10;

public class Phone {

    static int serialCounter = 100;
    String modelName;
    int serialNumber;

    public Phone(String modelName) {
        this.modelName = modelName;
        serialNumber = serialCounter;
        serialCounter++;
    }
}
