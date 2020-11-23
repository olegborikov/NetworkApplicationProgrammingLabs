package com.borikov.laba7_2.dao;

import com.borikov.laba7_2.entity.Letter;
import com.borikov.laba7_2.exception.DaoException;

import java.util.List;

public interface LetterDao {
    boolean add(Letter letter) throws DaoException;

    List<Letter> findAll() throws DaoException;
}
