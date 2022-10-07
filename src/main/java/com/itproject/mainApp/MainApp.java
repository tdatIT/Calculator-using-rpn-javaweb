package com.itproject.mainApp;

import com.itproject.model.*;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String args[]) {
        List<MathSymbol> list = new ArrayList<MathSymbol>();
        String infix = "(12*(24+4)/4)+22/242";
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

        CalculatorPostfix calculatorPostfix = new CalculatorPostfix( calculatorInfix.calculateResult());
        System.out.println("Result:"+calculatorPostfix.calculateResult());


    }
}
