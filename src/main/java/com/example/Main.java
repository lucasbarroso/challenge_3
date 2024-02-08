package com.example;

import com.example.entities.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ProductService productOperation = new ProductService();
        Product productD = new Product("product D", "New cat toy trinket", 99.00);

        // productOperation.save(productD);
        
        // System.out.println(productOperation.findAll());

        // productOperation.deleteById(4);
        System.out.println(productOperation.findAllObjects());
    }
}