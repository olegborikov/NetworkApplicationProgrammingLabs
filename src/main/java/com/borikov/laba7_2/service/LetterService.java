package com.borikov.laba7_2.service;

import com.borikov.laba7_2.entity.Letter;
import com.borikov.laba7_2.exception.ServiceException;

import java.util.List;

public interface LetterService {
    boolean sendLetter(String theme, String text, String senderId, String receiverId) throws ServiceException;

    List<Letter> findAllLetters() throws ServiceException;
}
