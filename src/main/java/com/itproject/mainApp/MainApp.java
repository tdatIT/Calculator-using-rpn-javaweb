package com.itproject.mainApp;

import com.itproject.model.CalculatorInfix;
import com.itproject.model.CalculatorString;
import com.itproject.model.MathSymbol;
import com.itproject.model.Operand;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String args[]) {
        List<MathSymbol> list = new ArrayList<MathSymbol>();
        String infix = "(4*(12+3)/2*(5+5)-(100*2))/2";
        CalculatorString calculator = new CalculatorString(infix);
        for (MathSymbol object : calculator.calculateResult()) {
            if (object.getClass() == Operand.class) {
                System.out.println(object.getValue() + " - TYPE: operand");
            } else
                System.out.println(object.getValue() + " - TYPE: operator");
        }

        CalculatorInfix calculatorInfix = new CalculatorInfix(calculator.calculateResult());
        for (MathSymbol object : calculatorInfix.calculateResult()) {
                System.out.print(object.getValue() +" ");
        }


    }
}
