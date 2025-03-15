package com.example.demo.calculator.expression;

import com.example.demo.calculator.Calculator;
import com.example.demo.calculator.expression.tokenizer.Tokenizer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

@Component
public class ExpressionCalculator implements Calculator {

    private final Tokenizer tokenizer;
    private final OperatorPrecedence operatorPrecedence;
    private final ExpressionRules expressionRules;

    public ExpressionCalculator(Tokenizer tokenizer, OperatorPrecedence operatorPrecedence, ExpressionRules expressionRules) {
        this.tokenizer = tokenizer;
        this.operatorPrecedence = operatorPrecedence;
        this.expressionRules = expressionRules;
    }

    public double compute(String expression) {
        System.out.println("Input Expression: " + expression); // Add this

        if (!expressionRules.isValidExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        List<String> tokens = tokenizer.tokenize(expression);
        System.out.println("Tokens: " + tokens); // Add this

        List<String> outputQueue = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            System.out.println("Processing Token: " + token); // Add this
            if (expressionRules.isNumber(token)) {
                outputQueue.add(token);
                System.out.println("Added to outputQueue: " + token); // Add this
            } else if (expressionRules.isOperator(token)) {
                while (!operatorStack.isEmpty() && expressionRules.isOperator(operatorStack.peek()) &&
                        operatorPrecedence.hasHigherPrecedence(operatorStack.peek(), token)) {
                    outputQueue.add(operatorStack.pop());
                    System.out.println("Moved operator from stack to outputQueue"); // Add this
                }
                operatorStack.push(token);
                System.out.println("Pushed operator to stack: " + token); // Add this
            } else if (token.equals("(")) {
                operatorStack.push(token);
                System.out.println("Pushed ( to stack"); // Add this
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                    System.out.println("Moved operator from stack to outputQueue (inside ) processing)"); // Add this
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                    System.out.println("Popped ( from stack"); // Add this
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            }
            System.out.println("Output Queue: " + outputQueue); // Add this
            System.out.println("Operator Stack: " + operatorStack); // Add this
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek().equals("(")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            outputQueue.add(operatorStack.pop());
            System.out.println("Moved remaining operator from stack to outputQueue"); // Add this
        }

        System.out.println("Final Output Queue: " + outputQueue); // Add this

        Stack<Double> evaluationStack = new Stack<>();
        for (String token : outputQueue) {
            if (expressionRules.isNumber(token)) {
                evaluationStack.push(Double.parseDouble(token));
                System.out.println("Pushed value to evaluation stack: " + token); // Add this
            } else if (expressionRules.isOperator(token)) {
                if (evaluationStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: Not enough operands for operator " + token);
                }
                double operand2 = evaluationStack.pop();
                double operand1 = evaluationStack.pop();
                double result = performOperation(operand1, operand2, token);
                evaluationStack.push(result);
                System.out.println("Performed operation " + token + " with " + operand1 + " and " + operand2 + " and pushed result " + result); // Add this
            }
            System.out.println("Evaluation Stack: " + evaluationStack); // Add this
        }

        if (evaluationStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return evaluationStack.pop();
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}