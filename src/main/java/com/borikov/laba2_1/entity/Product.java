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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        if (Double.compare(product.price, price) != 0) {
            return false;
        }
        if (isStock != product.isStock) {
            return false;
        }
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isStock ? 1 : 0);
        return result;
    }
}
