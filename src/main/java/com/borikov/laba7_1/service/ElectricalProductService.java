package com.borikov.laba7_1.service;

import com.borikov.laba7_1.entity.ElectricalProduct;
import com.borikov.laba7_1.exception.ServiceException;

import java.util.List;

public interface ElectricalProductService {
    boolean addElectricalProduct(String name, String price, String quantity,
                                 String issueYear) throws ServiceException;

    boolean removeElectricalProduct(String id) throws ServiceException;

    boolean updateElectricalProduct(String id, String name, String price,
                                    String quantity, String issueYear) throws ServiceException;

    List<ElectricalProduct> findAllElectricalProducts() throws ServiceException;
}
