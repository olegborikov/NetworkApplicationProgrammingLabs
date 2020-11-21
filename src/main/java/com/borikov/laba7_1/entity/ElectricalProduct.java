package com.borikov.laba7_1.entity;

public class ElectricalProduct {
    private Long electricalProductId;
    private String name;
    private double price;
    private int quantity;
    private int issueYear;

    public ElectricalProduct(Long electricalProductId, String name, double price, int quantity, int issueYear) {
        this.electricalProductId = electricalProductId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.issueYear = issueYear;
    }

    public Long getElectricalProductId() {
        return electricalProductId;
    }

    public void setElectricalProductId(Long electricalProductId) {
        this.electricalProductId = electricalProductId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ElectricalProduct electricalProduct = (ElectricalProduct) o;
        if (Double.compare(electricalProduct.price, price) != 0) {
            return false;
        }
        if (quantity != electricalProduct.quantity) {
            return false;
        }
        if (issueYear != electricalProduct.issueYear) {
            return false;
        }
        if (electricalProductId != null ?
                !electricalProductId.equals(electricalProduct.electricalProductId)
                : electricalProduct.electricalProductId != null) {
            return false;
        }
        return name != null ? name.equals(electricalProduct.name) : electricalProduct.name == null;
    }

    @Override
    public int hashCode() {
        int hashCode;
        long temp;
        hashCode = electricalProductId != null ? electricalProductId.hashCode() : 0;
        hashCode = 31 * hashCode + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        hashCode = 31 * hashCode + (int) (temp ^ (temp >>> 32));
        hashCode = 31 * hashCode + quantity;
        hashCode = 31 * hashCode + issueYear;
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder stringRepresentation = new StringBuilder("ElectricalProduct{");
        stringRepresentation.append("electricalProductId=").append(electricalProductId);
        stringRepresentation.append(", name='").append(name).append('\'');
        stringRepresentation.append(", price=").append(price);
        stringRepresentation.append(", quantity=").append(quantity);
        stringRepresentation.append(", issueYear=").append(issueYear);
        stringRepresentation.append('}');
        return stringRepresentation.toString();
    }
}
