package com.borikov.laba4_2.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CustomFileWriter {
    private static final String PATH = "output/output.txt";
    private static final String INFO = "x = %.2f, y = %.2f, z = %.2f result = %.2f%n";

    public void writeInFile(double x, double y, double z, double result) {
        String lineInfo = String.format(INFO, x, y, z, result);
        try {
            Files.write(Paths.get(PATH), lineInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
