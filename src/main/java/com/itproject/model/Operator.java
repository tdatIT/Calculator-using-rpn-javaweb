package com.itproject.model;

public class Operator extends MathSymbol {

    public Operator(String value) {
        super(value);
    }


    public int getPriority() {
        switch (getFirstCharacter()) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
