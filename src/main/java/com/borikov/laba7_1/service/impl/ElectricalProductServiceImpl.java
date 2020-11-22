package com.borikov.laba7_1.service.impl;

import com.borikov.laba7_1.dao.ElectricalProductDao;
import com.borikov.laba7_1.dao.impl.ElectricalProductDaoImpl;
import com.borikov.laba7_1.entity.ElectricalProduct;
import com.borikov.laba7_1.exception.DaoException;
import com.borikov.laba7_1.exception.ServiceException;
import com.borikov.laba7_1.service.ElectricalProductService;
import com.borikov.laba7_1.validator.ElectricalProductValidator;

import java.util.List;

public class ElectricalProductServiceImpl implements ElectricalProductService {
    private final ElectricalProductDao electricalProductDao = ElectricalProductDaoImpl.getInstance();

    @Override
    public boolean addElectricalProduct(String name, String price,
                                        String quantity, String issueYear) throws ServiceException {
        boolean isElectricalProductAdded = false;
        try {
            if (ElectricalProductValidator.isNameCorrect(name) && ElectricalProductValidator.isPriceCorrect(price)
                    && ElectricalProductValidator.isQuantityCorrect(quantity)
                    && ElectricalProductValidator.isIssueYearCorrect(issueYear)) {
                double parsedPrice = Double.parseDouble(price);
                int parsedQuantity = Integer.parseInt(quantity);
                int parsedIssueYear = Integer.parseInt(issueYear);
                ElectricalProduct electricalProduct =
                        new ElectricalProduct(null, name, parsedPrice, parsedQuantity, parsedIssueYear);
                isElectricalProductAdded = electricalProductDao.add(electricalProduct);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isElectricalProductAdded;
    }

    @Override
    public boolean removeElectricalProduct(String id) throws ServiceException {
        boolean isElectricalProductRemoved = false;
        try {
            if (ElectricalProductValidator.isIdCorrect(id)) {
                long parsedId = Long.parseLong(id);
                isElectricalProductRemoved = electricalProductDao.remove(parsedId);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isElectricalProductRemoved;
    }

    @Override
    public boolean updateElectricalProduct(String id, String name, String price,
                                           String quantity, String issueYear) throws ServiceException {
        boolean isElectricalProductUpdated = false;
        try {
            if (ElectricalProductValidator.isIdCorrect(id) && ElectricalProductValidator.isNameCorrect(name)
                    && ElectricalProductValidator.isPriceCorrect(price)
                    && ElectricalProductValidator.isQuantityCorrect(quantity)
                    && ElectricalProductValidator.isIssueYearCorrect(issueYear)) {
                long parsedId = Long.parseLong(id);
                double parsedPrice = Double.parseDouble(price);
                int parsedQuantity = Integer.parseInt(quantity);
                int parsedIssueYear = Integer.parseInt(issueYear);
                ElectricalProduct electricalProduct =
                        new ElectricalProduct(parsedId, name, parsedPrice, parsedQuantity, parsedIssueYear);
                isElectricalProductUpdated = electricalProductDao.update(electricalProduct);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isElectricalProductUpdated;
    }

    @Override
    public List<ElectricalProduct> findAllElectricalProducts() throws ServiceException {
        List<ElectricalProduct> electricalProducts;
        try {
            electricalProducts = electricalProductDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return electricalProducts;
    }
}
