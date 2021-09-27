package com.javamentor.calculator;

public class Converters {
    private final Utils utils;

    public Converters(Utils utils) {
        this.utils = utils;
    }

    public Integer convertToArabic(String romanDigit) {
        if (utils.getRomanArabicMap().containsKey(romanDigit)) {
            return utils.getRomanArabicMap().get(romanDigit);
        }
        return null;
    }

    public String convertToRoman(Integer arabicDigit) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < utils.getArabicDigits().length) {
            while ((arabicDigit - utils.getArabicDigits()[i]) >= 0) {
                arabicDigit -= utils.getArabicDigits()[i];
                result.append(utils.getRomanDigits()[i]);
            }
            i++;
        }
        return result.toString();
    }
}