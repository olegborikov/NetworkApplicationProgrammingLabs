package com.borikov.laba1.print;

import com.borikov.laba1.entity.Product;

public class InfoWriter {
    public void printName(Product product) {
        product.printName();
    }

    public void printPrice(Product product) {
        product.printPrice();
    }

    public void printStock(Product product) {
        product.printStock();
    }
}
