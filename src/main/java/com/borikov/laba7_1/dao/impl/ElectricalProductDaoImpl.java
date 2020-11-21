package com.borikov.laba7_1.dao.impl;

import com.borikov.laba7_1.dao.ColumnName;
import com.borikov.laba7_1.dao.ElectricalProductDao;
import com.borikov.laba7_1.entity.ElectricalProduct;
import com.borikov.laba7_1.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElectricalProductDaoImpl implements ElectricalProductDao {
    private static final ElectricalProductDaoImpl instance = new ElectricalProductDaoImpl();
    private static final String ADD = "INSERT INTO electrical_product (name, price, quantity, issue_year) "
            + "VALUES (?, ?, ?, ?)";
    private static final String REMOVE = "DELETE FROM electrical_product WHERE electrical_product_id = ?";
    private static final String UPDATE = "UPDATE electrical_product SET name = ?, price = ?, "
            + "quantity = ?, issue_year = ? WHERE electrical_product_id = ?";
    private static final String FIND_ALL = "SELECT electrical_product_id, name, price, quantity, issue_year "
            + "FROM electrical_product";
    private static final String URL = "jdbc:mysql://localhost:3306/laba7_1?useUnicode=true&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "root";

    private ElectricalProductDaoImpl() {
    }

    public static ElectricalProductDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(ElectricalProduct electricalProduct) throws DaoException {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, electricalProduct.getName());
            statement.setDouble(2, electricalProduct.getPrice());
            statement.setInt(3, electricalProduct.getQuantity());
            statement.setInt(4, electricalProduct.getIssueYear());
            boolean isAdded = statement.executeUpdate() > 0;
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                electricalProduct.setElectricalProductId(generatedKeys.getLong(1));
            }
            return isAdded;
        } catch (SQLException e) {
            throw new DaoException("Error while adding electrical product: " + electricalProduct, e);
        }
    }

    @Override
    public boolean remove(long id) throws DaoException {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(REMOVE)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException("Error while removing electrical product: id = " + id, e);
        }
    }

    @Override
    public boolean update(ElectricalProduct electricalProduct) throws DaoException {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, electricalProduct.getName());
            statement.setDouble(2, electricalProduct.getPrice());
            statement.setInt(3, electricalProduct.getQuantity());
            statement.setInt(4, electricalProduct.getIssueYear());
            statement.setLong(5, electricalProduct.getElectricalProductId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException("Error while updating electrical product: " + electricalProduct, e);
        }
    }

    @Override
    public List<ElectricalProduct> findAll() throws DaoException {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            List<ElectricalProduct> electricalProducts = new ArrayList<>();
            while (resultSet.next()) {
                electricalProducts.add(createElectricalProductFromResultSet(resultSet));
            }
            return electricalProducts;
        } catch (SQLException e) {
            throw new DaoException("Error while finding all electrical products", e);
        }
    }

    private ElectricalProduct createElectricalProductFromResultSet(ResultSet resultSet) throws SQLException {
        long electricalProductId = resultSet.getLong(ColumnName.ELECTRICAL_PRODUCT_ID);
        String name = resultSet.getString(ColumnName.NAME);
        double price = resultSet.getDouble(ColumnName.PRICE);
        int quantity = resultSet.getInt(ColumnName.QUANTITY);
        int issueYear = resultSet.getInt(ColumnName.ISSUE_YEAR);
        return new ElectricalProduct(electricalProductId, name, price, quantity, issueYear);
    }
}
