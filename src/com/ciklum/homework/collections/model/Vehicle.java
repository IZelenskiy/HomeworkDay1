package com.ciklum.homework.collections.model;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle> {
    String producer;
    String model;
    int price;
    boolean fourWD;

    public Vehicle(String producer, String model, int price, boolean fourWD) {
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.fourWD = fourWD;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFourWD() {
        return fourWD;
    }

    public void setFourWD(boolean fourWD) {
        this.fourWD = fourWD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Vehicle other = (Vehicle) o;
        if (!Objects.equals(producer, other.producer))
            return false;

        if (!Objects.equals(model, other.model))
            return false;

        if (price != other.price)
            return false;

        if (fourWD != other.fourWD)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result *= prime * result + ((this.producer == null) ? 0 : this.producer.hashCode());
        result *= prime * result + ((this.model == null) ? 0 : this.model.hashCode());
        result *= prime * result + this.price;
        result *= prime * result + ((this.fourWD) ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car [ Producer: "+ this.producer +
                ", Model: "+ this.model +
                ", Price: "+ this.price +
                ", FourWD: "+ this.fourWD +
                " ]";
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.price < o.getPrice()) {
            return -1;
        } else if (this.price > o.getPrice()) {
            return 1;
        }

        return 0;
    }
}
