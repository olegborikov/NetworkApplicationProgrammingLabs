package com.borikov.laba7_1.validator;

public class ElectricalProductValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String NAME_REGEX = "^.{2,25}$";
    private static final String PRICE_REGEX = "^[1-9]\\d{0,4}(.\\d{0,2})?$";
    private static final String QUANTITY_REGEX = "^\\d{1,6}$";
    private static final String ISSUE_YEAR_REGEX = "^20[\\d]{2}$";

    private ElectricalProductValidator() {
    }

    public static boolean isIdCorrect(String id) {
        return isStringCorrect(id, ID_REGEX);
    }

    public static boolean isNameCorrect(String name) {
        return isStringCorrect(name, NAME_REGEX);
    }

    public static boolean isPriceCorrect(String price) {
        return isStringCorrect(price, PRICE_REGEX);
    }

    public static boolean isQuantityCorrect(String quantity) {
        return isStringCorrect(quantity, QUANTITY_REGEX);
    }

    public static boolean isIssueYearCorrect(String issueYear) {
        return isStringCorrect(issueYear, ISSUE_YEAR_REGEX);
    }

    private static boolean isStringCorrect(String line, String regex) {
        boolean isStringCorrect = false;
        if (line != null) {
            isStringCorrect = line.matches(regex);
        }
        return isStringCorrect;
    }
}
