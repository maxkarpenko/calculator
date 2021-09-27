package com.javamentor.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private int operandLeft;
    private int operandRight;
    private String operator;

    private int calculate(int operandLeft, String operator, int operandRight) {
        int result = 0;
        switch (operator) {
            case "+":
                result = operandLeft + operandRight;
                break;
            case "-":
                result = operandLeft - operandRight;
                break;
            case "*":
                result = operandLeft * operandRight;
                break;
            case "/":
                result = operandLeft / operandRight;
                break;
        }
        return result;
    }

    public String getResult(String input) throws Exception {
        boolean isRoman;
        Utils utils = new Utils();

        List<String> expression = Arrays.asList(input.split(" "));

        if (expression.size() != 3) {
            throw new Exception("Must be separated by space");
        }

        if (utils.isOperatorValid(expression.get(1))) {
            operator = expression.get(1);
        } else {
            throw new Exception("Incorrect OPERATOR");
        }

        if (utils.isArabic(expression.get(0)) && utils.isArabic(expression.get(2))) {
            operandLeft = Integer.parseInt(expression.get(0));
            operandRight = Integer.parseInt(expression.get(2));
            isRoman = false;
        } else if (utils.isRoman(expression.get(0)) && utils.isRoman(expression.get(2))) {
            operandLeft = utils.convertToArabic(expression.get(0));
            operandRight = utils.convertToArabic(expression.get(2));
            isRoman = true;
        } else {
            throw new Exception("Must be the same numeric system");
        }

        if (!(operandLeft >= 1 && operandLeft <= 10)) {
            throw new Exception("Left OPERAND must be from 1 to 10, or I to X");
        }

        if (!(operandRight >= 1 && operandRight <= 10)) {
            throw new Exception("Right OPERAND must be from 1 to 10, or I to X");
        }

        int result = calculate(operandLeft, operator, operandRight);

        if (isRoman) {
            String sign = result < 0 ? "-" : "";
            return sign + utils.convertToRoman(Math.abs(result));
        }

        return String.valueOf(result);
    }

}