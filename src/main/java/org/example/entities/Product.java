package org.example.entities;

public class Product {
    private final long id;
    private final String name;
    private final String category;
    private final Double price;

    public Product(String name, long id, Double price, String category) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
