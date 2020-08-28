package com.borikov.laba3_2.entity;

public class Blouse implements Clothes, Printable {
    private String manufacturer;
    private double price;
    private String style;
    private double sleeveLength;
    private double percentageOfWool;

    public Blouse(String manufacturer, double price, String style,
                  double sleeveLength, double percentageOfWool) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.style = style;
        this.sleeveLength = sleeveLength;
        this.percentageOfWool = percentageOfWool;
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

    public double getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(double sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public double getPercentageOfWool() {
        return percentageOfWool;
    }

    public void setPercentageOfWool(double percentageOfWool) {
        this.percentageOfWool = percentageOfWool;
    }

    @Override
    public String brand() {
        return "Lacoste";
    }

    @Override
    public void printInfo() {
        System.out.println("Blouse");
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Price: " + price);
        System.out.println("Style: " + style);
        System.out.println("Brand: " + brand());
        System.out.println("Sleeve length: " + sleeveLength);
        System.out.println("Percentage of wool: " + percentageOfWool);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Blouse blouse = (Blouse) o;
        if (Double.compare(blouse.price, price) != 0) {
            return false;
        }
        if (Double.compare(blouse.sleeveLength, sleeveLength) != 0) {
            return false;
        }
        if (Double.compare(blouse.percentageOfWool, percentageOfWool) != 0) {
            return false;
        }
        if (manufacturer != null
                ? !manufacturer.equals(blouse.manufacturer)
                : blouse.manufacturer != null) {
            return false;
        }
        return style != null ? style.equals(blouse.style) : blouse.style == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturer != null ? manufacturer.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (style != null ? style.hashCode() : 0);
        temp = Double.doubleToLongBits(sleeveLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(percentageOfWool);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Blouse{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append(", sleeveLength=").append(sleeveLength);
        sb.append(", percentageOfWool=").append(percentageOfWool);
        sb.append('}');
        return sb.toString();
    }
}
