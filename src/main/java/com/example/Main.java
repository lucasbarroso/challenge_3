package com.example;

import com.example.repository.Product;
import com.example.repository.ProductRepository;
import com.example.repository.Repository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ProductRepository productOperation = new ProductRepository();
        Product productD = new Product("product D", "New cat toy trinket", 99.00);

        // productOperation.save(productD);
        
        // Repository conn= new Repository();
        // conn.getConnection();
        // System.out.println(productOperation.findById(2));
        
    }
}