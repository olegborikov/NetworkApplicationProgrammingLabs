package com.borikov.laba3_2.entity;

public class DownJacket extends Jacket {

    public DownJacket(String manufacturer, double price,
                      String style, String seasonality, boolean isHood) {
        super(manufacturer, price, style, seasonality, isHood);
    }

    @Override
    public String brand() {
        return "Pool and bear";
    }

    @Override
    public void printInfo() {
        System.out.println("Down Jacket");
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Price: " + price);
        System.out.println("Style: " + style);
        System.out.println("Brand: " + brand());
        System.out.println("Seasonality: " + seasonality);
        System.out.println("Hood: " + isHood);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DownJacket{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
