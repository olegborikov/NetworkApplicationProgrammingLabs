package com.borikov.laba7_2.service.impl;

import com.borikov.laba7_2.dao.UserDao;
import com.borikov.laba7_2.dao.impl.UserDaoImpl;
import com.borikov.laba7_2.entity.User;
import com.borikov.laba7_2.exception.DaoException;
import com.borikov.laba7_2.exception.ServiceException;
import com.borikov.laba7_2.service.UserService;
import com.borikov.laba7_2.validator.LetterValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public List<User> findAllUsers() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserByMinimumLetterSize() throws ServiceException {
        try {
            return userDao.findByMinimumLetterSize();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findUsersByLetterTheme(String theme) throws ServiceException {
        try {
            List<User> users = new ArrayList<>();
            if (LetterValidator.isThemeCorrect(theme)) {
                users = userDao.findByLetterTheme(theme);
            }
            return users;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findUsersByLetterThemeAbsence(String theme) throws ServiceException {
        try {
            List<User> users = new ArrayList<>();
            if (LetterValidator.isThemeCorrect(theme)) {
                users = userDao.findByLetterThemeAbsence(theme);
            }
            return users;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
