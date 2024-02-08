package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.entities.Product;
import com.example.exception.ValidationErrorException;
import com.example.repository.ProductRepository;

public class ProductService {
    private ProductRepository repository = new ProductRepository();

    public List<Product> findAllObjects() {
            List<Product> products = repository.findAll();
            
            for (Product product : products) {

                if (product.getId() < 0) {

                    throw new ValidationErrorException("\n{\n\n"
                + " \"code\": 400,\n\n"
                + " \"status\": \"Bad Request\",\n\n"
                + " \"messege\": \"O campo 'nome' e obrigatorio\",\n\n"
                + " \"details\": [\n\n"
                + "  {\n\n"
                + "     \"field\": \"nome\",\n\n"
                + "     \"message\": \"O campo 'nome' e obrigatorio\",\n\n"
                + "  }\n\n"
                + " ]\n\n"
                + "}");

                }
            }

            return products;
    }

    public void saveObject(Product product) throws RuntimeException {

        if (product.getName() == null) {
            throw new ValidationErrorException("\n{\n\n"
                + " \"code\": 400,\n\n"
                + " \"status\": \"Bad Request\",\n\n"
                + " \"messege\": \"O campo 'nome' e obrigatorio\",\n\n"
                + " \"details\": [\n\n"
                + "  {\n\n"
                + "     \"field\": \"nome\",\n\n"
                + "     \"message\": \"O campo 'nome' e obrigatorio\",\n\n"
                + "  }\n\n"
                + " ]\n\n"
                + "}");
        } else {

            List<Product> products = repository.findAll();
            for (Product productAux : products) {

                if (productAux.getName().equals(product.getName())) {
                    throw new ValidationErrorException("\n{\n\n"
                + " \"code\": 400,\n\n"
                + " \"status\": \"Bad Request\",\n\n"
                + " \"messege\": \"O valor no campo 'nome' ja existe\",\n\n"
                + " \"details\": [\n\n"
                + "  {\n\n"
                + "     \"field\": \"nome\",\n\n"
                + "     \"message\": \"O valor no campo 'nome' ja existe\",\n\n"
                + "  }\n\n"
                + " ]\n\n"
                + "}");
                }

            }
        repository.save(product);
        }
    }
}