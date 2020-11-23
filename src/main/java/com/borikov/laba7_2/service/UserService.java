package com.borikov.laba7_2.service;

import com.borikov.laba7_2.entity.User;
import com.borikov.laba7_2.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers() throws ServiceException;

    Optional<User> findUserByMinimumLetterSize() throws ServiceException;

    List<User> findUsersByLetterTheme(String theme) throws ServiceException;

    List<User> findUsersByLetterThemeAbsence(String theme) throws ServiceException;
}
