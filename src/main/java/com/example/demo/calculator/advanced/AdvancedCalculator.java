package com.example.demo.calculator.advanced;


import com.example.demo.calculator.Calculator;
import org.springframework.stereotype.Component;  // Add this import

@Component 

public class AdvancedCalculator implements Calculator {

   
    public double compute(String expression) {
        try {
            return evaluateAdvanced(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid advanced expression: " + expression, e);
        }
    }

    private double evaluateAdvanced(String expression) {
        // Expecting something like "sqrt(25)" or "log(10)"
        String functionName = expression.substring(0, expression.indexOf('(')).trim();
        String argumentString = expression.substring(expression.indexOf('(') + 1, expression.indexOf(')')).trim();
        double argument = Double.parseDouble(argumentString);

        switch (functionName) {
            case "sqrt":
                return sqrt(argument);
            case "sin":
                return sin(argument);
            case "log":
                return log(argument);
            case "power":
                // Handle power(base,exponent) - requires different parsing
                String[] powerArgs = argumentString.split(",");
                if (powerArgs.length != 2) {
                    throw new IllegalArgumentException("Invalid power function format. Use power(base,exponent)");
                }
                double base = Double.parseDouble(powerArgs[0].trim());
                double exponent = Double.parseDouble(powerArgs[1].trim());
                return power(base, exponent);
            default:
                throw new IllegalArgumentException("Invalid function: " + functionName);
        }
    }


    private double sqrt(double a) {
        return Math.sqrt(a);
    }

    private double sin(double a) {
        return Math.sin(a);
    }

    private double log(double a) {
        return Math.log(a);
    }

    private double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}