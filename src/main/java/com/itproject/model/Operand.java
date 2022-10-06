package com.itproject.model;

public class Operand extends MathSymbol {

    public Operand(String value) {
        super(value);
    }

    public float getDecimalValue() {
        if (!value.isEmpty())
            return Float.valueOf(value);
        return 0;
    }

}
