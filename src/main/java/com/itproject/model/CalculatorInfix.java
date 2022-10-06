package com.itproject.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CalculatorInfix implements ICalculable {

    private List<MathSymbol> infix;

    public List<MathSymbol> getInfix() {
        return infix;
    }

    public void setInfix(List<MathSymbol> infix) {
        this.infix = infix;
    }

    public CalculatorInfix(List<MathSymbol> infix) {
        this.infix = infix;
    }

    @Override
    public Queue<MathSymbol> calculateResult() {
        Queue<MathSymbol> _queue = new LinkedList<MathSymbol>();
        Stack<MathSymbol> _stack = new Stack<MathSymbol>();

        for (MathSymbol object : infix) {
            if (object.getClass() == Operand.class)
                _queue.add(object);
            else if (object.getTypeBracket() == MathSymbol.OPEN_BRACKET)
                _stack.push(object);
            else if (object.getTypeBracket() == MathSymbol.CLOSED_BRACKET) {
                while (!_stack.empty() &&
                        _stack.peek().getTypeBracket() != MathSymbol.OPEN_BRACKET) {
                    _queue.add(_stack.pop());
                }
                if (!_stack.empty() &&
                        _stack.peek().getTypeBracket() != MathSymbol.OPEN_BRACKET)
                    return null;
                else {
                    _stack.pop();
                }
            } else {
                while (!_stack.empty() &&
                        ((Operator) _stack.peek()).getPriority() >=
                                ((Operator) object).getPriority()) {
                    _queue.add(_stack.pop());
                }
                _stack.push(object);
            }

        }
        while (!_stack.empty())
            _queue.add(_stack.pop());
        return _queue;
    }
}
