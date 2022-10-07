package com.itproject.model;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.Stack;

public class CalculatorPostfix implements ICalculable {
    private Queue<MathSymbol> postfix;

    public CalculatorPostfix(Queue<MathSymbol> postfix) {
        this.postfix = postfix;
    }

    public Queue<MathSymbol> getPostfix() {
        return postfix;
    }

    public void setPostfix(Queue<MathSymbol> postfix) {
        this.postfix = postfix;
    }

    @Override
    public String calculateResult() {
        try {
            Stack<MathSymbol> _stack = new Stack<>();
            String final_result = "";
            for (MathSymbol object : postfix) {
                if (object.getClass() == Operand.class) {
                    _stack.push(object);
                } else {
                    Operand op1 = (Operand) _stack.pop();
                    Operand op2 = (Operand) _stack.pop();
                    Operator opt = (Operator) object;
                    Operand op = calTowVar(op2, op1, opt);
                    _stack.push(op);
                }
            }
            final_result = _stack.pop().getValue();
            BigDecimal decimal = new BigDecimal(final_result);
            return decimal.setScale(2, BigDecimal.ROUND_CEILING).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Operand calTowVar(Operand op1, Operand op2, Operator opt) {
        BigDecimal bd = null;
        float var1 = op1.getDecimalValue();
        float var2 = op2.getDecimalValue();
        float result = 0;

        switch (opt.getFirstCharacter()) {
            case '+':
                result = var1 + var2;
                break;
            case '-':
                result = var1 - var2;
                break;
            case '*':
                result = var1 * var2;
                break;
            case '/':
                result = var1 / var2;
                break;
        }
        bd = new BigDecimal(result);
        String value = bd.toString();
        return new Operand(value);
    }
}
