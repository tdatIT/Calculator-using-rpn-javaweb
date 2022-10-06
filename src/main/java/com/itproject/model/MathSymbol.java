package com.itproject.model;

public abstract class MathSymbol {
    public static final int OPEN_BRACKET = 1;
    public static final int CLOSED_BRACKET = 2;

    protected String value;

    public MathSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    protected char getFirstCharacter() {
        return this.value.charAt(0);
    }

    public boolean isBracket() {
        char ch = getFirstCharacter();
        if (ch == '(' || ch == ')')
            return true;
        return false;
    }

    public int getTypeBracket() {
        char ch = getFirstCharacter();
        if (ch == '(')
            return OPEN_BRACKET;
        if (ch == ')')
            return CLOSED_BRACKET;
        return -1;
    }

}
