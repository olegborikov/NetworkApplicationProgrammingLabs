package com.borikov.laba7_2.dao.impl;

import com.borikov.laba7_2.dao.ColumnName;
import com.borikov.laba7_2.dao.LetterDao;
import com.borikov.laba7_2.entity.Letter;
import com.borikov.laba7_2.exception.DaoException;
import com.borikov.laba7_2.pool.ConnectionPool;

import java.sql.*;

public class LetterDaoImpl implements LetterDao {
    private static final LetterDaoImpl instance = new LetterDaoImpl();
    private static final String ADD = "INSERT INTO letters (theme, text, departure_date, sender_users_id_fk, "
            + "receiver_users_id_fk) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_AMOUNT_OF_SENT_BY_USER_ID = "SELECT COUNT(letters_id) AS rowcount "
            + "FROM letters WHERE sender_users_id_fk = ?";
    private static final String FIND_AMOUNT_OF_RECEIVED_BY_USER_ID = "SELECT COUNT(letters_id) AS rowcount "
            + "FROM letters WHERE receiver_users_id_fk = ?";

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
    public int findAmountOfSentByUserId(long userId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AMOUNT_OF_SENT_BY_USER_ID)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            int amount = 0;
            if (resultSet.next()) {
                amount = resultSet.getInt(ColumnName.ROWCOUNT);
            }
            return amount;
        } catch (SQLException e) {
            throw new DaoException("Error while finding sent letters by user id: " + userId, e);
        }
    }

    @Override
    public int findAmountOfReceivedByUserId(long userId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AMOUNT_OF_RECEIVED_BY_USER_ID)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            int amount = 0;
            if (resultSet.next()) {
                amount = resultSet.getInt(ColumnName.ROWCOUNT);
            }
            return amount;
        } catch (SQLException e) {
            throw new DaoException("Error while finding received letters by user id: " + userId, e);
        }
    }
}
