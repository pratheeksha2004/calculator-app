package com.example.demo.calculator.expression;

import org.springframework.stereotype.Component; // Add this import

@Component 
public interface ExpressionRules {
    boolean isValidExpression(String expression);
    boolean isNumber(String token);
    boolean isOperator(String token);
}