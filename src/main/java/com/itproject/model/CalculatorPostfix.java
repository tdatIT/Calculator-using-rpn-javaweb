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
        Stack<MathSymbol> _stack = new Stack<>();
        String final_result = "";
        for (MathSymbol object : postfix) {
            if (object.getClass() == Operand.class) {
                _stack.push(object);
            } else {
                Operand op1 = (Operand) _stack.pop();
                Operand op2 = (Operand) _stack.pop();
                Operator opt = (Operator) object;
                Operand op = calTowVar(op1, op2, opt);
                _stack.push(op);
            }
        }
        final_result = _stack.pop().getValue();
        return final_result;
    }

    public Operand calTowVar(Operand op1, Operand op2, Operator opt) {
        BigDecimal bd = null;
        float var1 = op1.getDecimalValue();
        float var2 = op2.getDecimalValue();
        float result = 0;

        switch (opt.getFirstCharacter()) {
            case '+':
                result = var1 + var2;
            case '-':
                result = var1 - var2;
            case '*':
                result = var1 * var2;
            case '/':
                result = var1 / var2;
        }
        bd = new BigDecimal(result);
        String value = bd.setScale(BigDecimal.ROUND_CEILING).toString();
        return new Operand(value);
    }
}
