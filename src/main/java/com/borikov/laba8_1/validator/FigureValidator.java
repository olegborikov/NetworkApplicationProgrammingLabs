package com.borikov.laba8_1.validator;

public class FigureValidator {
    private static final String LENGTH_REGEX = "^[1-9]\\d{0,4}(\\.\\d{0,2})?$";
    private static final String ACCURACY_REGEX = "^[1-5]$";

    private FigureValidator() {
    }

    public static boolean isLengthCorrect(String length) {
        boolean result = false;
        if (length != null) {
            result = length.matches(LENGTH_REGEX);
        }
        return result;
    }

    public static boolean isAccuracyCorrect(String accuracy) {
        boolean result = false;
        if (accuracy != null) {
            result = accuracy.matches(ACCURACY_REGEX);
        }
        return result;
    }
}
