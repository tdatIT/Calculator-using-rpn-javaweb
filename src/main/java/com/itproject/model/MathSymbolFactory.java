package com.itproject.model;

public class MathSymbolFactory {

    public MathSymbol createObject(String value) {
        MathSymbol object = null;
        char ch = value.charAt(0);
        if (ch >= '0' && ch <= '9') {
            object = new Operand(value);
        } else if (ch == '-' && value.length() >= 2) {
            object = new Operand(value);
        } else {
            object = new Operator(value);
        }
        return object;
    }

}
