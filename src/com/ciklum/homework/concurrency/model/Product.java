package com.ciklum.homework.concurrency.model;

public class Product {
    public int id;
    public String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
