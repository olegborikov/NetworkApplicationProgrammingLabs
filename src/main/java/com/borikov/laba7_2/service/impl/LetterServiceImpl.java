package com.borikov.laba7_2.service.impl;

import com.borikov.laba7_2.dao.LetterDao;
import com.borikov.laba7_2.dao.impl.LetterDaoImpl;
import com.borikov.laba7_2.entity.Letter;
import com.borikov.laba7_2.exception.DaoException;
import com.borikov.laba7_2.exception.ServiceException;
import com.borikov.laba7_2.service.LetterService;
import com.borikov.laba7_2.validator.LetterValidator;

import java.time.LocalDate;

public class LetterServiceImpl implements LetterService {
    private final LetterDao letterDao = LetterDaoImpl.getInstance();

    @Override
    public boolean sendLetter(String theme, String text, String senderId, String receiverId) throws ServiceException {
        boolean isLetterSent = false;
        try {
            if (LetterValidator.isThemeCorrect(theme) && LetterValidator.isTextCorrect(text)
                    && LetterValidator.isIdCorrect(senderId) && LetterValidator.isIdCorrect(receiverId)) {
                long senderIdParsed = Long.parseLong(senderId);
                long receiverIdParsed = Long.parseLong(receiverId);
                Letter letter = new Letter(null, theme, text, LocalDate.now(), senderIdParsed, receiverIdParsed);
                isLetterSent = letterDao.add(letter);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isLetterSent;
    }

    @Override
    public int findAmountOfSentLettersByUserId(Long userId) throws ServiceException {
        try {
            return letterDao.findAmountOfSentByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findAmountOfReceivedLettersByUserId(Long userId) throws ServiceException {
        try {
            return letterDao.findAmountOfReceivedByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
