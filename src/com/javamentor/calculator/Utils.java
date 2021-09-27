package com.javamentor.calculator;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    private final Converters converters = new Converters(this);

    public Map<String, Integer> getRomanArabicMap() {
        return romanArabicMap;
    }

    public int[] getArabicDigits() {
        return arabicDigits;
    }

    public String[] getRomanDigits() {
        return romanDigits;
    }

    private final Map<String, Integer> romanArabicMap = new HashMap<>();

    private final int[] arabicDigits = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romanDigits = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public Utils() {
        romanArabicMap.put("I", 1);
        romanArabicMap.put("II", 2);
        romanArabicMap.put("III", 3);
        romanArabicMap.put("IV", 4);
        romanArabicMap.put("V", 5);
        romanArabicMap.put("VI", 6);
        romanArabicMap.put("VII", 7);
        romanArabicMap.put("VIII", 8);
        romanArabicMap.put("IX", 9);
        romanArabicMap.put("X", 10);
    }

    public boolean isArabic(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isRoman(String input) {
        return romanArabicMap.containsKey(input);
    }

    public boolean isOperatorValid(String operator) {
        return "*".equals(operator) || "/".equals(operator) || "+".equals(operator) || "-".equals(operator);
    }

    public Integer convertToArabic(String romanDigit) {
        return converters.convertToArabic(romanDigit);
    }

    public String convertToRoman(Integer arabicDigit) {
        return converters.convertToRoman(arabicDigit);
    }

}