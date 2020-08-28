package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class MotherBoard extends ComputerComponent {
    private String socket;
    private String memoryType;

    public MotherBoard() {
        generateName();
        socket = "";
        memoryType = "";
    }

    public MotherBoard(String name, String model, int cost, int price,
                       String socket, String memoryType) {
        super(name, model, cost, price);
        this.socket = socket;
        this.memoryType = memoryType;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    @Override
    protected void generateName() {
        name = "mother board";
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
        MotherBoard that = (MotherBoard) o;
        if (socket != null
                ? !socket.equals(that.socket)
                : that.socket != null) {
            return false;
        }
        return memoryType != null
                ? memoryType.equals(that.memoryType)
                : that.memoryType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (socket != null ? socket.hashCode() : 0);
        result = 31 * result + (memoryType != null ? memoryType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MotherBoard{");
        sb.append(super.toString());
        sb.append(", socket='").append(socket).append('\'');
        sb.append(", memoryType='").append(memoryType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
