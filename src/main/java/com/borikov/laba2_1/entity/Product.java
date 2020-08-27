package com.borikov.laba2_1.entity;

public class Product {
    private String name;
    private double price;
    private boolean isStock;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, boolean isStock) {
        this.name = name;
        this.price = price;
        this.isStock = isStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    public void printInfo() {
        System.out.printf("Name: %s%nPrice: %.2f%nIn stock: %b%n", name, price, isStock);
    }
}
