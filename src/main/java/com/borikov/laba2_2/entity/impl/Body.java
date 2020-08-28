package com.borikov.laba2_2.entity.impl;

import com.borikov.laba2_2.entity.ComputerComponent;

public class Body extends ComputerComponent {
    private String material;
    private String type;

    public Body() {
        generateName();
        material = "";
        type = "";
    }

    public Body(String name, String model, int cost, int price, String material, String type) {
        super(name, model, cost, price);
        this.material = material;
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected void generateName() {
        name = "body";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)){
            return false;
        }
        Body body = (Body) o;
        if (material != null ? !material.equals(body.material) : body.material != null){
            return false;
        }
        return type != null ? type.equals(body.type) : body.type == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Body{");
        sb.append(super.toString());
        sb.append(", material='").append(material).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
