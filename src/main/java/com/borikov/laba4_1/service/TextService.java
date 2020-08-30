package com.borikov.laba4_1.service;

import com.borikov.laba4_1.util.TextHandler;

public class TextService {
    private static final String LINE_DELIMITER = "!|\\.|\\?|\\.\\.\\.";
    private static final String WORD_REGEX = "^.*%s.*$";

    public String findSentencesByWord(String word) {
        StringBuilder answer = new StringBuilder();
        String[] linedText = TextHandler.TEXT.split(LINE_DELIMITER);
        for (String line : linedText) {
            if (line.matches(String.format(WORD_REGEX, word))) {
                answer.append(line);
                answer.append(". ");
            }
        }
        return answer.toString();
    }
}
