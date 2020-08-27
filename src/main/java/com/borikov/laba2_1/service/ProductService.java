package com.borikov.laba2_1.service;

import com.borikov.laba2_1.entity.Product;

public class ProductService {
    public static double calculateGeneralPrice(Product[] products) {
        double generalPrice = 0;
        for (Product product : products) {
            generalPrice += product.getPrice();
        }
        return generalPrice;
    }

    public static int calculateGeneralStock(Product[] products) {
        int generalStock = 0;
        for (Product product : products) {
            if (product.isStock()) {
                generalStock++;
            }
        }
        return generalStock;
    }
}
