package com.itproject.model;

public class Operand extends MathSymbol {

    public Operand(String value) {
        super(value);
    }

    public float getDecimalValue() {
        if (!value.isEmpty())
            return Float.parseFloat(value);
        return 0;
    }

}
