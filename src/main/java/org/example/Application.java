package org.example;

import org.example.entities.Customer;
import org.example.entities.Order;
import org.example.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Don Chisciotte", 738189, 20.0, "books"));
        products.add(new Product("I promessi sposi", 639286, 110.0, "books"));
        products.add(new Product("Guerra e pace", 925142, 120.0, "books"));
        products.add(new Product("salviette", 172933, 1.50, "baby"));
        products.add(new Product("ciuccio", 283746, 3.0, "baby"));
        products.add(new Product("pannolini", 998152, 5.0, "baby"));
        products.add(new Product("t-shirt", 638928, 15.0, "boys"));
        products.add(new Product("air-max", 192833, 110.0, "boys"));
        products.add(new Product("occhiali da sole", 524221, 20.0, "boys"));
        products.add(new Product("Xiaomi", 936254, 1.300, "smartphone"));
        products.add(new Product("Realme", 172936, 1.100, "smartphone"));
        products.add(new Product("Samsung", 732648, 1.500, "smartphone"));

        List<Product> filteredBooks = products.stream().filter(book -> book.getCategory().equals("books") && book.getPrice() > 100).toList();
        filteredBooks.forEach(System.out::println);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("in consegna", 363738, LocalDate.of(2026, 5, 21),
                LocalDate.of(2026, 5, 25), products.stream().filter(baby -> baby.getCategory().equals("baby")).toList(), new Customer(629182, "Antonio", 2)));

        System.out.println(orders);

        List<String> couponBoys = products.stream()
                .filter(product -> product.getCategory().equals("boys"))
                .map(p -> p.getName() +
                        " | originale: " + p.getPrice() +
                        " | scontato: " + (p.getPrice() * 0.9))
                .toList();

        couponBoys.forEach(System.out::println);

        List<Product> filteredClient = orders.stream()
                .filter(product -> product.getCustomer().getTier() == 2)
                .filter(data -> !data.getOrderDate().isBefore(LocalDate.of(2026, 5, 21)) &&
                        !data.getDeliveryDate().isAfter(LocalDate.of(2026, 5, 25)))
                .flatMap(product -> product.getProducts().stream()).toList();

        System.out.println(filteredClient);
    }
}
