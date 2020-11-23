package com.borikov.laba7_2.dao;

import com.borikov.laba7_2.entity.Letter;
import com.borikov.laba7_2.exception.DaoException;

public interface LetterDao {
    boolean add(Letter letter) throws DaoException;

    int findAmountOfSentByUserId(long userId) throws DaoException;

    int findAmountOfReceivedByUserId(long userId) throws DaoException;
}
