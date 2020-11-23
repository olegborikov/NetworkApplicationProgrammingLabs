package com.borikov.laba7_2.dao.impl;

import com.borikov.laba7_2.dao.ColumnName;
import com.borikov.laba7_2.dao.UserDao;
import com.borikov.laba7_2.entity.User;
import com.borikov.laba7_2.exception.DaoException;
import com.borikov.laba7_2.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final UserDaoImpl instance = new UserDaoImpl();
    private static final String FIND_ALL = "SELECT users_id, name, surname, patronymic, birthday FROM users ";
    private static final String FIND_BY_MINIMUM_LETTER_SIZE = "SELECT users_id, name, surname, patronymic, birthday "
            + "FROM users INNER JOIN letters ON users.users_id = letters.sender_users_id_fk "
            + "WHERE CHAR_LENGTH(text) = (SELECT MIN(CHAR_LENGTH(text)) FROM letters);\n";
    private static final String FIND_BY_LETTER_THEME = "SELECT users_id, name, surname, patronymic, birthday "
            + "FROM users INNER JOIN letters ON users.users_id = letters.receiver_users_id_fk "
            + "WHERE theme LIKE ? GROUP BY users_id";
    private static final String FIND_BY_LETTER_THEME_ABSENCE = "SELECT users_id, name, surname, patronymic, birthday "
            + "FROM users LEFT JOIN letters ON users.users_id = letters.receiver_users_id_fk "
            + "WHERE (theme NOT LIKE ? OR theme IS NULL) AND users_id NOT IN (SELECT users_id "
            + "FROM users INNER JOIN letters ON users.users_id = letters.receiver_users_id_fk "
            + "WHERE theme LIKE ? GROUP BY users_id) GROUP BY users_id";

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<User> findAll() throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(createUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
    }

    @Override
    public Optional<User> findByMinimumLetterSize() throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_MINIMUM_LETTER_SIZE)) {
            ResultSet resultSet = statement.executeQuery();
            Optional<User> userOptional = Optional.empty();
            if (resultSet.next()) {
                userOptional = Optional.of(createUserFromResultSet(resultSet));
            }
            return userOptional;
        } catch (SQLException e) {
            throw new DaoException("Error while finding user by minimum letter size", e);
        }
    }

    @Override
    public List<User> findByLetterTheme(String theme) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LETTER_THEME)) {
            statement.setString(1, theme);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(createUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException("Error while finding users by letter theme", e);
        }
    }

    @Override
    public List<User> findByLetterThemeAbsence(String theme) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LETTER_THEME_ABSENCE)) {
            statement.setString(1, theme);
            statement.setString(2, theme);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(createUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException("Error while finding users by letter theme фиыутсу", e);
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ColumnName.USER_ID);
        String name = resultSet.getString(ColumnName.NAME);
        String surname = resultSet.getString(ColumnName.SURNAME);
        String patronymic = resultSet.getString(ColumnName.PATRONYMIC);
        Date date = new Date(resultSet.getLong(ColumnName.BIRTHDAY));
        return new User(id, name, surname, patronymic, date.toLocalDate());
    }
}
