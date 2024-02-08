package com.example.service;

import java.util.List;

import com.example.entities.Product;
import com.example.repository.ProductRepository;

public class ProductService {
    private ProductRepository repository = new ProductRepository();

    public List<Product> findAllObjects() {
        try {
            List<Product> products = repository.findAll();
            
            for (Product product : products) {

                if (product.getId() < 0 || product.getName() == null) {

                    throw new RuntimeException("ID = " + product.getId() + " and/or name is not valid"); 

                }
            }

            return products;

        } catch (Exception e) {
            // algum outro erro não tratado lá em cima
            throw new RuntimeException("Unknow error");
        }
    }
}