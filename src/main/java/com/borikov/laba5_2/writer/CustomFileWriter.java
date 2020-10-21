package com.borikov.laba5_2.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CustomFileWriter {
    private static final String PATH = "output/questionnaire.txt";
    private static final String INFO = "%s, %s, %s, %s\n";

    public void writeInFile(String name, String surname,
                            String age, String city) {
        String lineInfo = String.format(INFO, name, surname, age, city);
        try {
            Files.write(Paths.get(PATH), lineInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
