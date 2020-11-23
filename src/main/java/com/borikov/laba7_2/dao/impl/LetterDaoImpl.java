package com.borikov.laba7_2.dao.impl;

import com.borikov.laba7_2.dao.ColumnName;
import com.borikov.laba7_2.dao.LetterDao;
import com.borikov.laba7_2.entity.Letter;
import com.borikov.laba7_2.exception.DaoException;
import com.borikov.laba7_2.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LetterDaoImpl implements LetterDao {
    private static final LetterDaoImpl instance = new LetterDaoImpl();
    private static final String ADD = "INSERT INTO letters (theme, text, departure_date, sender_users_id_fk, "
            + "receiver_users_id_fk) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT letters_id, theme, text, departure_date, sender_users_id_fk, "
            + "receiver_users_id_fk FROM letters";

    private LetterDaoImpl() {
    }

    public static LetterDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(Letter letter) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, letter.getTheme());
            statement.setString(2, letter.getText());
            Date date = Date.valueOf(letter.getDepartureDate());
            statement.setLong(3, date.getTime());
            statement.setLong(4, letter.getSenderId());
            statement.setLong(5, letter.getReceiverId());
            boolean isAdded = statement.executeUpdate() > 0;
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                letter.setLetterId(generatedKeys.getLong(1));
            }
            return isAdded;
        } catch (SQLException e) {
            throw new DaoException("Error while adding letter: " + letter, e);
        }
    }

    @Override
    public List<Letter> findAll() throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            List<Letter> letters = new ArrayList<>();
            while (resultSet.next()) {
                letters.add(createLetterFromResultSet(resultSet));
            }
            return letters;
        } catch (SQLException e) {
            throw new DaoException("Error while finding all letters", e);
        }
    }

    private Letter createLetterFromResultSet(ResultSet resultSet) throws SQLException {
        long letterId = resultSet.getLong(ColumnName.LETTER_ID);
        String theme = resultSet.getString(ColumnName.THEME);
        String text = resultSet.getString(ColumnName.TEXT);
        Date date = new Date(resultSet.getLong(ColumnName.DEPARTURE_DATE));
        long senderId = resultSet.getLong(ColumnName.SENDER_USER_ID);
        long receiverId = resultSet.getLong(ColumnName.RECEIVER_USER_ID);
        return new Letter(letterId, theme, text, date.toLocalDate(), senderId, receiverId);
    }
}
