package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;
import com.borikov.laba2_2.entity.PriceInterface;
import com.borikov.laba2_2.util.IdGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Order implements PriceInterface {
    private long id;
    private double cost;
    private double price;
    private List<ComputerComponent> computerComponents;

    public Order() {
        computerComponents = new ArrayList<>();
        id = IdGenerator.generateId();
    }

    public Order(long id, double cost, double price,
                 List<ComputerComponent> computerComponents) {
        this.id = id;
        this.cost = cost;
        this.price = price;
        this.computerComponents = computerComponents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ComputerComponent> getComputerComponents() {
        return Collections.unmodifiableList(computerComponents);
    }

    public void setComputerComponents(List<ComputerComponent> computerComponents) {
        this.computerComponents = computerComponents;
    }

    public boolean addComponent(ComputerComponent computerComponent) {
        return computerComponents.add(computerComponent);
    }

    public ComputerComponent removedComponent(int index) {
        return computerComponents.remove(index);
    }

    public void printInfo() {
        Iterator<ComputerComponent> iterator = computerComponents.iterator();
        while (iterator.hasNext()) {
            ComputerComponent computerComponent = iterator.next();
            System.out.println(computerComponent.toString());
        }
        System.out.println("cost: " + cost + ", price:" + price);
    }

    @Override
    public double countPrice() {
        double commonPrice = 0;
        double commonCost = 0;
        Iterator<ComputerComponent> iterator = computerComponents.iterator();
        while (iterator.hasNext()) {
            ComputerComponent computerComponent = iterator.next();
            commonCost = commonCost + computerComponent.getCost();
            commonPrice = commonPrice + computerComponent.getPrice();
        }
        cost = commonCost;
        price = commonPrice;
        return commonPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if (id != order.id) {
            return false;
        }
        if (Double.compare(order.cost, cost) != 0) {
            return false;
        }
        if (Double.compare(order.price, price) != 0) {
            return false;
        }
        return computerComponents != null
                ? computerComponents.equals(order.computerComponents)
                : order.computerComponents == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result
                + (computerComponents != null ? computerComponents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", cost=").append(cost);
        sb.append(", price=").append(price);
        sb.append(", computerComponents=").append(computerComponents);
        sb.append('}');
        return sb.toString();
    }
}
