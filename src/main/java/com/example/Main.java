package com.example;

import com.example.repository.ProductRepository;
import com.example.repository.Repository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ProductRepository searchProduct = new ProductRepository();
        
        // Repository conn= new Repository();
        // conn.getConnection();
        System.out.println(searchProduct.findById(2));
    }
}