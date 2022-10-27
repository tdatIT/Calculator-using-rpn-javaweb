package com.itproject.model;

import java.util.Queue;

public class CalculatorList implements ICalculable {
    private Queue<MathSymbol> list;

    public CalculatorList(Queue<MathSymbol> list) {
        this.list = list;
    }

    @Override
    public String calculateResult() {
        String data = "";
        for (MathSymbol ch : this.list) {
            data += ch.getValue() + " ";
        }
        return data;
    }
}
