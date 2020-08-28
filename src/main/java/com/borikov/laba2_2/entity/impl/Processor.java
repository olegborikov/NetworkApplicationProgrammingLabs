package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class Processor extends ComputerComponent {
    private String socket;
    private double actFrequency;

    public Processor() {
        generateName();
        socket = "";
    }

    public Processor(String name, String model, int cost, int price, String socket, double actFrequency) {
        super(name, model, cost, price);
        this.socket = socket;
        this.actFrequency = actFrequency;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public double getActFrequency() {
        return actFrequency;
    }

    public void setActFrequency(double actFrequency) {
        this.actFrequency = actFrequency;
    }

    @Override
    protected void generateName() {
        name = "processor";
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
        Processor processor = (Processor) o;
        if (Double.compare(processor.actFrequency, actFrequency) != 0) {
            return false;
        }
        return socket != null ? socket.equals(processor.socket) : processor.socket == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (socket != null ? socket.hashCode() : 0);
        temp = Double.doubleToLongBits(actFrequency);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Processor{");
        sb.append(super.toString());
        sb.append(", socket='").append(socket).append('\'');
        sb.append(", actFrequency=").append(actFrequency);
        sb.append('}');
        return sb.toString();
    }
}
