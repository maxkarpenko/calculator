package com.javamentor.calculator;

public class Exception extends java.lang.Exception {
    public Exception() {
        System.out.print("Invalid format: ");
    }

    public Exception(String message) {
        this();
        System.out.println(message);
    }
}