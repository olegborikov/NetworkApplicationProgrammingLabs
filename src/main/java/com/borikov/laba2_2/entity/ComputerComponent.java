package com.borikov.laba2_2.entity;

import com.borikov.laba2_2.util.IdGenerator;

public abstract class ComputerComponent implements PriceInterface {
    protected long id;
    protected String name;
    protected String model;
    protected int cost;
    protected int price;

    public ComputerComponent() {
        this.id = IdGenerator.generateId();
        name = "";
        model = "";
    }

    public ComputerComponent(String name, String model, int cost, int price) {
        this.id = IdGenerator.generateId();
        this.name = name;
        this.model = model;
        this.cost = cost;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected abstract void generateName();

    @Override
    public double countPrice() {
        double price = ((cost * 1.2) * 1.2);
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComputerComponent that = (ComputerComponent) o;
        if (id != that.id) {
            return false;
        }
        if (cost != that.cost) {
            return false;
        }
        if (price != that.price) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return model != null ? model.equals(that.model) : that.model == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", price=").append(price);
        return sb.toString();
    }
}
