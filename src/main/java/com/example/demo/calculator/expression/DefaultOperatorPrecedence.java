package com.example.demo.calculator.expression;


import org.springframework.stereotype.Component;

@Component
public class DefaultOperatorPrecedence implements OperatorPrecedence {

    @Override
    public boolean hasHigherPrecedence(String op1, String op2) {
        // BODMAS/PEMDAS precedence:
        // 1. Parentheses (handled in the main algorithm)
        // 2. Exponents (not implemented in this example)
        // 3. Multiplication and Division (same precedence)
        // 4. Addition and Subtraction (same precedence)

        if (isHighPrecedence(op1) && isLowPrecedence(op2)) {
            return true;
        }
        return false;
    }

    private boolean isHighPrecedence(String op) {
        return op.equals("*") || op.equals("/");
    }

    private boolean isLowPrecedence(String op) {
        return op.equals("+") || op.equals("-");
    }
}