package com.borikov.laba3_2.entity;

public class Pants implements Clothes, Printable {
    private String manufacturer;
    private double price;
    private String style;
    private double flared;

    public Pants(String manufacturer, double price, String style, double flared) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.style = style;
        this.flared = flared;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getFlared() {
        return flared;
    }

    public void setFlared(double flared) {
        this.flared = flared;
    }

    @Override
    public String brand() {
        return "Puma";
    }

    @Override
    public void printInfo() {
        System.out.println("Pants");
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Price: " + price);
        System.out.println("Style: " + style);
        System.out.println("Brand: " + brand());
        System.out.println("Flared: " + flared);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pants pants = (Pants) o;
        if (Double.compare(pants.price, price) != 0) {
            return false;
        }
        if (Double.compare(pants.flared, flared) != 0) {
            return false;
        }
        if (manufacturer != null
                ? !manufacturer.equals(pants.manufacturer)
                : pants.manufacturer != null) {
            return false;
        }
        return style != null ? style.equals(pants.style) : pants.style == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturer != null ? manufacturer.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (style != null ? style.hashCode() : 0);
        temp = Double.doubleToLongBits(flared);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pants{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append(", flared=").append(flared);
        sb.append('}');
        return sb.toString();
    }
}
