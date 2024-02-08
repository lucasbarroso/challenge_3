package com.example;

import java.sql.SQLException;

import com.example.entities.Product;
import com.example.exception.ValidationErrorException;
import com.example.service.ProductService;


public class Main {
    public static void main(String[] args) throws ValidationErrorException {
        System.out.println("Hello world!");
        ProductService productOperation = new ProductService();
        Product productD = new Product("televisaaaaao", "New cat toy trinket", 99.00);

        productOperation.saveObject(productD);
        System.out.println("ok");

        // productOperation.save(productD);
        
        // System.out.println(productOperation.findAll());

        // productOperation.deleteById(4);
        //System.out.println(productOperation.findAllObjects());
    }
}