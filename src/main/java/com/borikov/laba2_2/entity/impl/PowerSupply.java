package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class PowerSupply extends ComputerComponent {
    private int power;

    public PowerSupply() {
        generateName();
    }

    public PowerSupply(String name, String model, int cost, int price, int power) {
        super(name, model, cost, price);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    protected void generateName() {
        name = "power supply";
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
        PowerSupply that = (PowerSupply) o;
        return power == that.power;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + power;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PowerSupply{");
        sb.append(super.toString());
        sb.append(", power=").append(power);
        sb.append('}');
        return sb.toString();
    }
}
