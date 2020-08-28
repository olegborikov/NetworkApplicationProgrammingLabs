package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class GraphicsCard extends ComputerComponent {
    private String videoMemoryType;
    private String videoMemoryBus;

    public GraphicsCard() {
        generateName();
        videoMemoryType = "";
        videoMemoryBus = "";
    }

    public GraphicsCard(String name, String model, int cost, int price,
                        String videoMemoryType, String videoMemoryBus) {
        super(name, model, cost, price);
        this.videoMemoryType = videoMemoryType;
        this.videoMemoryBus = videoMemoryBus;
    }

    public String getVideoMemoryType() {
        return videoMemoryType;
    }

    public void setVideoMemoryType(String videoMemoryType) {
        this.videoMemoryType = videoMemoryType;
    }

    public String getVideoMemoryBus() {
        return videoMemoryBus;
    }

    public void setVideoMemoryBus(String videoMemoryBus) {
        this.videoMemoryBus = videoMemoryBus;
    }

    @Override
    protected void generateName() {
        name = "graphics card";
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
        GraphicsCard that = (GraphicsCard) o;
        if (videoMemoryType != null
                ? !videoMemoryType.equals(that.videoMemoryType)
                : that.videoMemoryType != null) {
            return false;
        }
        return videoMemoryBus != null
                ? videoMemoryBus.equals(that.videoMemoryBus)
                : that.videoMemoryBus == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (videoMemoryType != null ? videoMemoryType.hashCode() : 0);
        result = 31 * result + (videoMemoryBus != null ? videoMemoryBus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GraphicsCard{");
        sb.append(super.toString());
        sb.append(", videoMemoryType='").append(videoMemoryType).append('\'');
        sb.append(", videoMemoryBus='").append(videoMemoryBus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
