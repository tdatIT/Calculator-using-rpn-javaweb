package com.itproject.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CalculatorString implements ICalculable {
    public String expression;

    public CalculatorString(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public List<MathSymbol> calculateResult() {
        String token = "";
        List<MathSymbol> list = new LinkedList<MathSymbol>();
        MathSymbolFactory factory = new MathSymbolFactory();
        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    token += ch;
                } else {
                    if (!token.equals("")) {
                        MathSymbol operand = factory.createObject(token);
                        list.add(operand);
                        token = "";
                    }
                    list.add(factory.createObject(ch+""));
                }
            }
            if (!token.equals("")) {
                list.add(factory.createObject(token));
                token = "";
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
