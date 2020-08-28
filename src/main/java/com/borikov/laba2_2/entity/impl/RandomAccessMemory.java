package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class RandomAccessMemory extends ComputerComponent {
    private int capacity;
    private String type;

    public RandomAccessMemory() {
        generateName();
        type = "";
    }

    public RandomAccessMemory(String name, String model, int cost, int price, int capacity, String type) {
        super(name, model, cost, price);
        this.capacity = capacity;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected void generateName() {
        name = "random access memory";
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
        RandomAccessMemory that = (RandomAccessMemory) o;
        if (capacity != that.capacity) {
            return false;
        }
        return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RandomAccessMemory{");
        sb.append(super.toString());
        sb.append(", capacity=").append(capacity);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
