package com.borikov.laba7_2.service;

import com.borikov.laba7_2.exception.ServiceException;

public interface LetterService {
    boolean sendLetter(String theme, String text, String senderId, String receiverId) throws ServiceException;

    int findAmountOfSentLettersByUserId(Long userId) throws ServiceException;

    int findAmountOfReceivedLettersByUserId(Long userId) throws ServiceException;
}
