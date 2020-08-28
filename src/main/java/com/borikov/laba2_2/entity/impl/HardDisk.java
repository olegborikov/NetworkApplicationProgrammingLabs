package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class HardDisk extends ComputerComponent {
    private int capacity;

    public HardDisk() {
        generateName();
    }

    public HardDisk(String name, String model, int cost, int price, int capacity) {
        super(name, model, cost, price);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected void generateName() {
        name = "hard disk";
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
        HardDisk hardDisk = (HardDisk) o;
        return capacity == hardDisk.capacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HardDisk{");
        sb.append(super.toString());
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
