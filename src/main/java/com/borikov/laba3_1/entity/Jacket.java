package com.borikov.laba3_1.entity;

public class Jacket extends Clothes {
    private String seasonality;
    private boolean isHood;

    public Jacket() {
    }

    public Jacket(String manufacturer, double price, String style) {
        super(manufacturer, price, style);
    }

    public Jacket(String manufacturer, double price,
                  String style, String seasonality, boolean isHood) {
        super(manufacturer, price, style);
        this.seasonality = seasonality;
        this.isHood = isHood;
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
    public String brand() {
        return "Calvin Klein";
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
        Jacket jacket = (Jacket) o;
        if (isHood != jacket.isHood) {
            return false;
        }
        return seasonality != null
                ? seasonality.equals(jacket.seasonality)
                : jacket.seasonality == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (seasonality != null ? seasonality.hashCode() : 0);
        result = 31 * result + (isHood ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jacket{");
        sb.append("seasonality='").append(seasonality).append('\'');
        sb.append(", isHood=").append(isHood);
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", price=").append(price);
        sb.append(", style='").append(style).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
