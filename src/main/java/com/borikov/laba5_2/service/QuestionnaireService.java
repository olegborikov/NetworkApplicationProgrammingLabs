package com.borikov.laba5_2.service;

import com.borikov.laba5_2.writer.CustomFileWriter;

public class QuestionnaireService {
    public boolean saveQuestionnaire(String name, String surname,
                                     String age, String city) {
        boolean result = name != null && surname != null && age != null
                && city != null && !name.isBlank() && !surname.isBlank()
                && !age.isBlank() && !city.isBlank();
        if (result) {
            CustomFileWriter customFileWriter = new CustomFileWriter();
            customFileWriter.writeInFile(name, surname, age, city);
        }
        return result;
    }
}
