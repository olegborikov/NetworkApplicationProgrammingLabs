package com.borikov.laba8_1.service.impl;

import com.borikov.laba8_1.exception.IncorrectDataException;
import com.borikov.laba8_1.service.FigureService;
import com.borikov.laba8_1.validator.FigureValidator;

import java.math.BigDecimal;

public class FigureServiceImpl implements FigureService {
    @Override
    public double calculateBallVolume(String radius, String accuracy) throws IncorrectDataException {
        if (!FigureValidator.isLengthCorrect(radius) || !FigureValidator.isAccuracyCorrect(accuracy)) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        double radiusParsed = Double.parseDouble(radius);
        int accuracyParsed = Integer.parseInt(accuracy);
        double ballVolume = 4 * Math.PI * Math.pow(radiusParsed, 3) / 3;
        return roundUpNumber(ballVolume, accuracyParsed);
    }

    @Override
    public double calculateCubeVolume(String side, String accuracy) throws IncorrectDataException {
        if (!FigureValidator.isLengthCorrect(side) || !FigureValidator.isAccuracyCorrect(accuracy)) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        double sideParsed = Double.parseDouble(side);
        int accuracyParsed = Integer.parseInt(accuracy);
        double cubeVolume = Math.pow(sideParsed, 3);
        return roundUpNumber(cubeVolume, accuracyParsed);
    }

    @Override
    public double calculateParallelepipedVolume(String sideA, String sideB, String sideC, String accuracy)
            throws IncorrectDataException {
        if (!FigureValidator.isLengthCorrect(sideA) || !FigureValidator.isLengthCorrect(sideB)
                || !FigureValidator.isLengthCorrect(sideC) || !FigureValidator.isAccuracyCorrect(accuracy)) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        double sideAParsed = Double.parseDouble(sideA);
        double sideBParsed = Double.parseDouble(sideB);
        double sideCParsed = Double.parseDouble(sideC);
        int accuracyParsed = Integer.parseInt(accuracy);
        double cubeVolume = sideAParsed * sideBParsed * sideCParsed;
        return roundUpNumber(cubeVolume, accuracyParsed);
    }

    @Override
    public double calculateSphereVolume(String radius, String accuracy) throws IncorrectDataException {
        if (!FigureValidator.isLengthCorrect(radius) || !FigureValidator.isAccuracyCorrect(accuracy)) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        double radiusParsed = Double.parseDouble(radius);
        int accuracyParsed = Integer.parseInt(accuracy);
        double ballVolume = 4 * Math.PI * Math.pow(radiusParsed, 3) / 3;
        return roundUpNumber(ballVolume, accuracyParsed);
    }

    @Override
    public double calculateTetrahedronVolume(String side, String accuracy) throws IncorrectDataException {
        if (!FigureValidator.isLengthCorrect(side) || !FigureValidator.isAccuracyCorrect(accuracy)) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        double sideParsed = Double.parseDouble(side);
        int accuracyParsed = Integer.parseInt(accuracy);
        double cubeVolume = Math.pow(sideParsed, 3) * Math.sqrt(sideParsed) / 12;
        return roundUpNumber(cubeVolume, accuracyParsed);
    }

    @Override
    public double calculateTorusVolume(String radiusA, String radiusB, String accuracy) throws IncorrectDataException {
        if (!FigureValidator.isLengthCorrect(radiusA) || !FigureValidator.isLengthCorrect(radiusB)
                || !FigureValidator.isAccuracyCorrect(accuracy)) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        double radiusAParsed = Double.parseDouble(radiusA);
        double radiusBParsed = Double.parseDouble(radiusB);
        if (radiusAParsed > radiusBParsed) {
            throw new IncorrectDataException("Input data is incorrect");
        }
        int accuracyParsed = Integer.parseInt(accuracy);
        double cubeVolume = 2 * Math.pow(Math.PI, 2) * Math.pow(radiusAParsed, 2) * radiusBParsed;
        return roundUpNumber(cubeVolume, accuracyParsed);
    }

    private double roundUpNumber(double number, int accuracy) {
        BigDecimal bigDecimal =
                new BigDecimal(String.valueOf(number)).setScale(accuracy, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
