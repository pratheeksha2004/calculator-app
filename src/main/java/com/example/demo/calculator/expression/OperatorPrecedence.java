package com.example.demo.calculator.expression;

import org.springframework.stereotype.Component; // Add this import

@Component 
public interface OperatorPrecedence {
    boolean hasHigherPrecedence(String op1, String op2);
}