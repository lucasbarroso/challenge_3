package com.example;

import com.example.repository.Product;
import com.example.repository.ProductRepository;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ProductRepository productOperation = new ProductRepository();
        Product productD = new Product("product D", "New cat toy trinket", 99.00);

        // productOperation.save(productD);
        
        // System.out.println(productOperation.findAll());

        // productOperation.deleteById(4);
        
    }
}