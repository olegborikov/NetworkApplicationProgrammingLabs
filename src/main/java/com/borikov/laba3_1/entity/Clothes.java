package com.borikov.laba3_1.entity;

public class Clothes {
    protected String manufacturer;
    protected double price;
    protected String style;

    public Clothes() {
    }

    public Clothes(String manufacturer, double price, String style) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.style = style;
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

    public String brand() {
        return "default brand";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Clothes clothes = (Clothes) o;
        if (Double.compare(clothes.price, price) != 0) {
            return false;
        }
        if (manufacturer != null
                ? !manufacturer.equals(clothes.manufacturer)
                : clothes.manufacturer != null) {
            return false;
        }
        return style != null ? style.equals(clothes.style) : clothes.style == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturer != null ? manufacturer.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clothes{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
