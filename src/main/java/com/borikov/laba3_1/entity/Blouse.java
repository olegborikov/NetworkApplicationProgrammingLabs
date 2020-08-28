package com.borikov.laba3_1.entity;

public class Blouse extends Clothes {
    private double sleeveLength;
    private double percentageOfWool;

    public Blouse() {
    }

    public Blouse(String manufacturer, double price, String style) {
        super(manufacturer, price, style);
    }

    public Blouse(String manufacturer, double price, String style,
                  double sleeveLength, double percentageOfWool) {
        super(manufacturer, price, style);
        this.sleeveLength = sleeveLength;
        this.percentageOfWool = percentageOfWool;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Blouse blouse = (Blouse) o;
        if (Double.compare(blouse.sleeveLength, sleeveLength) != 0) {
            return false;
        }
        return Double.compare(blouse.percentageOfWool, percentageOfWool) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(sleeveLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(percentageOfWool);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Blouse{");
        sb.append("sleeveLength=").append(sleeveLength);
        sb.append(", percentageOfWool=").append(percentageOfWool);
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
