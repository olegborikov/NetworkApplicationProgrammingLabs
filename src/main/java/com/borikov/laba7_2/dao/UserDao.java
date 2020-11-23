package com.borikov.laba7_2.dao;

import com.borikov.laba7_2.entity.User;
import com.borikov.laba7_2.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll() throws DaoException;

    Optional<User> findByMinimumLetterSize() throws DaoException;

    List<User> findByLetterTheme(String theme) throws DaoException;

    List<User> findByLetterThemeAbsence(String theme) throws DaoException;
}
