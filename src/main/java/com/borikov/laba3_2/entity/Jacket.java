package com.borikov.laba3_2.entity;

public abstract class Jacket implements Clothes, Printable {
    protected String manufacturer;
    protected double price;
    protected String style;
    protected String seasonality;
    protected boolean isHood;

    public Jacket(String manufacturer, double price,
                  String style, String seasonality, boolean isHood) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.style = style;
        this.seasonality = seasonality;
        this.isHood = isHood;
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

    public String getSeasonality() {
        return seasonality;
    }

    public void setSeasonality(String seasonality) {
        this.seasonality = seasonality;
    }

    public boolean isHood() {
        return isHood;
    }

    public void setHood(boolean hood) {
        isHood = hood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Jacket jacket = (Jacket) o;
        if (Double.compare(jacket.price, price) != 0) {
            return false;
        }
        if (isHood != jacket.isHood) {
            return false;
        }
        if (manufacturer != null
                ? !manufacturer.equals(jacket.manufacturer)
                : jacket.manufacturer != null) {
            return false;
        }
        if (style != null ? !style.equals(jacket.style) : jacket.style != null) {
            return false;
        }
        return seasonality != null
                ? seasonality.equals(jacket.seasonality) :
                jacket.seasonality == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturer != null ? manufacturer.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (seasonality != null ? seasonality.hashCode() : 0);
        result = 31 * result + (isHood ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append(", Seasonality='").append(seasonality).append('\'');
        sb.append(", isHood=").append(isHood);
        return sb.toString();
    }
}
