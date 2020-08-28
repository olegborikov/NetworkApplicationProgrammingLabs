package com.borikov.laba3_1.entity;

public class Pants extends Clothes {
    private double flared;

    public Pants() {
    }

    public Pants(String manufacturer, double price, String style) {
        super(manufacturer, price, style);
    }

    public Pants(String manufacturer, double price, String style, double flared) {
        super(manufacturer, price, style);
        this.flared = flared;
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
        Pants pants = (Pants) o;
        return Double.compare(pants.flared, flared) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(flared);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pants{");
        sb.append("flared=").append(flared);
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
