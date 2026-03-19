package org.example.entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final long id;
    private final String status;
    private final LocalDate orderDate;
    private final LocalDate deliveryDate;
    private final List<Product> products;
    private final Customer customer;

    public Order(String status, long id, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.status = status;
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double calculateTotal() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
