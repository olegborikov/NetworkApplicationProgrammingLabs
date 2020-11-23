package com.borikov.laba7_2.validator;

public class LetterValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String THEME_REGEX = "^.{1,40}$";
    private static final String TEXT_REGEX = "^.{1,256}$";

    public static boolean isIdCorrect(String id) {
        return isStringCorrect(id, ID_REGEX);
    }

    public static boolean isThemeCorrect(String theme) {
        return isStringCorrect(theme, THEME_REGEX);
    }

    public static boolean isTextCorrect(String text) {
        return isStringCorrect(text, TEXT_REGEX);
    }

    private static boolean isStringCorrect(String line, String regex) {
        boolean isStringCorrect = false;
        if (line != null) {
            isStringCorrect = line.matches(regex);
        }
        return isStringCorrect;
    }
}
