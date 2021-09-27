package com.javamentor.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception, IOException {
        System.out.println("Enter your expression in format '[OPERAND] [OPERATION] [OPERAND]'");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        Calculator calculator = new Calculator();
        String result = calculator.getResult(input);
        System.out.println(result);
    }

}