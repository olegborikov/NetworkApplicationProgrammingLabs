package com.borikov.laba1.main;

import com.borikov.laba1.entity.Product;
import com.borikov.laba1.print.WriterInfo;

public class ProductMain {
    public static void main(String[] args) {
        Product product = new Product("PC", 1000, true);
        product.printName();
        product.printPrice();
        product.printStock();
        Product product1 = new Product();
        product1.setName("Mouse");
        product1.setPrice(10);
        product1.setStock(false);
        WriterInfo writerInfo = new WriterInfo();
        writerInfo.printName(product1);
        writerInfo.printPrice(product1);
        writerInfo.printStock(product1);
    }
}
