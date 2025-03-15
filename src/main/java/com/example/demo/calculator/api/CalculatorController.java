package com.example.demo.calculator.api;

import com.example.demo.calculator.Calculator;
import com.example.demo.calculator.basic.BasicCalculator;
import com.example.demo.calculator.advanced.AdvancedCalculator;
import com.example.demo.calculator.expression.ExpressionCalculator;
import com.example.demo.calculator.expression.tokenizer.Tokenizer;
import com.example.demo.calculator.expression.DefaultOperatorPrecedence;
import com.example.demo.calculator.expression.DefaultExpressionRules;
import com.example.demo.model.CalculationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calculate") // Base path for all calculator endpoints
public class CalculatorController {

    @Autowired
    private BasicCalculator basicCalculator;

    @Autowired
    private AdvancedCalculator advancedCalculator;

    @Autowired
    private ExpressionCalculator expressionCalculator;

    @GetMapping("/basic") // GET http://localhost:8080/calculate/basic
    public ResponseEntity<?> calculateBasic(@RequestBody CalculationRequest request) {
        try {
            double result = basicCalculator.compute(request.getExpression());
            Map<String, Double> response = new HashMap<>();
            response.put("result", result);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createErrorResponse("An unexpected error occurred: " + e.getMessage()));
        }
    }

    @GetMapping("/advanced") // GET http://localhost:8080/calculate/advanced
    public ResponseEntity<?> calculateAdvanced(@RequestBody CalculationRequest request) {
        try {
            double result = advancedCalculator.compute(request.getExpression());
            Map<String, Double> response = new HashMap<>();
            response.put("result", result);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createErrorResponse("An unexpected error occurred: " + e.getMessage()));
        }
    }

    @GetMapping("/expression") // GET http://localhost:8080/calculate/expression
    public ResponseEntity<?> calculateExpression(@RequestBody CalculationRequest request) {
        try {
            double result = expressionCalculator.compute(request.getExpression());
            Map<String, Double> response = new HashMap<>();
            response.put("result", result);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createErrorResponse("An unexpected error occurred: " + e.getMessage()));
        }
    }

    private Map<String, String> createErrorResponse(String errorMessage) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", errorMessage);
        return errorResponse;
    }
}