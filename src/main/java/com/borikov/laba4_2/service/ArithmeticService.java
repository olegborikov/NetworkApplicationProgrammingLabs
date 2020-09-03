package com.borikov.laba4_2.service;

public class ArithmeticService {
    public double calculateExpression(double x, double y, double z) {
        double firstStatement = Math.pow(Math.E, Math.abs(x - y))
                * Math.pow(Math.abs(x - y), x + y);
        double secondStatement = Math.atan(x) + Math.tan(z);
        double thirdStatement = Math.pow(x, 6) + Math.pow(Math.log(y), 2);
        return firstStatement / secondStatement + thirdStatement;
    }
}
