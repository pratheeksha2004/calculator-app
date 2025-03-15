package com.example.demo.calculator.expression;

import org.springframework.stereotype.Component; // Add this import

@Component 
public class DefaultExpressionRules implements ExpressionRules {
    @Override
    public boolean isValidExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return false;
        }

        String trimmedExpression = expression.trim();
        // More robust validation needed (parentheses, operator placement, etc.)
        return trimmedExpression.matches("[0-9+\\-*/(). ]+");
    }

    @Override
    public boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}