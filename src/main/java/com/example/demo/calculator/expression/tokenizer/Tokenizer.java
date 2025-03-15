package com.example.demo.calculator.expression.tokenizer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Tokenizer {

    public List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();

        // This regex now matches individual numbers, operators, and parentheses
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*|[+\\-*/()]");

        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }
}