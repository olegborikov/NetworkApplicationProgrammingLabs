package com.borikov.laba2.main;

import com.borikov.laba2.entity.Product;
import com.borikov.laba2.service.ProductService;

public class ProductMain {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Keyboard", 150);
        products[1] = new Product("PC");
        products[2] = new Product("Mouse", 10);
        products[3] = new Product("Phone", 100, true);
        products[4] = new Product("Chair", 50, false);
        for (Product product : products) {
            product.printInfo();
        }
        double generalPrice = ProductService.calculateGeneralPrice(products);
        int generalStock = ProductService.calculateGeneralStock(products);
        System.out.println("General price: " + generalPrice);
        System.out.println("General stock: " + generalStock);
    }
}
