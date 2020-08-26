package com.borikov.laba1.entity;

public class Product {
    private String name;
    private double price;
    private boolean isStock;

    public Product() {
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

    public void printName() {
        System.out.println("Name: " + name);
    }

    public void printPrice() {
        System.out.println("Price: " + price);
    }

    public void printStock() {
        System.out.println("Product in stock: " + isStock);
    }
}
