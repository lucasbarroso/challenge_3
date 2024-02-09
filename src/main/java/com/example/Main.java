package com.example;

import com.example.entities.Product;
import com.example.exception.ValidationErrorException;
import com.example.service.ProductService;


public class Main {
    public static void main(String[] args) throws ValidationErrorException {

        ProductService productOperation = new ProductService();
        Product productD = new Product("ProductD", "New cat toy trinket", 99.00);


        System.out.println(productD);

    }
}
        //productOperation.saveObject(productD);

        // productOperation.save(productD);
        
        // System.out.println(productOperation.findAll());

        // productOperation.deleteById(4);
        //System.out.println(productOperation.findAllObjects());