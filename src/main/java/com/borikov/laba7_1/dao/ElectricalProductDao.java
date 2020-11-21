package com.borikov.laba7_1.dao;

import com.borikov.laba7_1.entity.ElectricalProduct;
import com.borikov.laba7_1.exception.DaoException;

import java.util.List;

public interface ElectricalProductDao {
    boolean add(ElectricalProduct electricalProduct) throws DaoException;

    boolean remove(long id) throws DaoException;

    boolean update(ElectricalProduct electricalProduct) throws DaoException;

    List<ElectricalProduct> findAll() throws DaoException;
}
