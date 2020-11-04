package com.borikov.laba8_1.service;

import com.borikov.laba8_1.exception.IncorrectDataException;

public interface FigureService {
    double calculateBallVolume(String radius, String accuracy) throws IncorrectDataException;

    double calculateCubeVolume(String side, String accuracy) throws IncorrectDataException;

    double calculateParallelepipedVolume(String sideA, String sideB, String sideC, String accuracy)
            throws IncorrectDataException;

    double calculateSphereVolume(String radius, String accuracy) throws IncorrectDataException;

    double calculateTetrahedronVolume(String side, String accuracy) throws IncorrectDataException;

    double calculateTorusVolume(String radiusA, String radiusB, String accuracy) throws IncorrectDataException;
}
