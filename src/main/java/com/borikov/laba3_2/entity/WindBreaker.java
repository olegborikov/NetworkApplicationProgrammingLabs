package com.borikov.laba3_2.entity;

public class WindBreaker extends Jacket {
    public WindBreaker(String manufacturer, double price,
                       String style, String seasonality, boolean isHood) {
        super(manufacturer, price, style, seasonality, isHood);
    }

    @Override
    public String brand() {
        return "Calvin Klein";
    }

    @Override
    public void printInfo() {
        System.out.println("Wind Jacket");
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Price: " + price);
        System.out.println("Style: " + style);
        System.out.println("Brand: " + brand());
        System.out.println("Seasonality: " + seasonality);
        System.out.println("Hood: " + isHood);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WindBreaker{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
