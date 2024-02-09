package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.entities.Product;
import com.example.exception.ValidationErrorException;
import com.example.repository.ProductRepository;
import com.google.gson.Gson;


/**
 * Serviço para aplicar as regras de negócio ao utilizar as operações do crud solicitado.
 */

public class ProductService {
    private ProductRepository repository = new ProductRepository();
    Gson gson = new Gson();

    /**
     * Repassa os objetos do método findAll e válida se os ids que estão no banco de dados são válidos.
     * 
     * @return Uma representação JSON de todos os produtos.
     */

    public String findAllObjects() {
        List<Product> products = repository.findAll();

        for (Product product : products) {

            if (product.getId() < 1) {

                throw new ValidationErrorException("\n{\n\n"
                        + " \"code\": 400,\n\n"
                        + " \"status\": \"Bad Request\",\n\n"
                        + " \"messege\": \"O campo 'id' é inválido\",\n\n"
                        + " \"details\": [\n\n"
                        + "  {\n\n"
                        + "     \"field\": \"nome\",\n\n"
                        + "     \"message\": \"O campo 'id' é inválido\",\n\n"
                        + "  }\n\n"
                        + " ]\n\n"
                        + "}");

            }
        }

        return gson.toJson(products);
    }

    /**
     * Repassa os objetos do método findById e válida se os ids que estão no banco de dados são válidos.
     * 
     * @param id O ID do produto a ser buscado.
     * @return Uma representação JSON do produto correspondente ao ID fornecido.
     */

    public String findObjectById(int id) {
        List<Product> products = repository.findById(id);

        for (Product product : products) {

            if (product.getId() < 1) {

                throw new ValidationErrorException("\n{\n\n"
                        + " \"code\": 400,\n\n"
                        + " \"status\": \"Bad Request\",\n\n"
                        + " \"messege\": \"O campo 'id' é invalido\",\n\n"
                        + " \"details\": [\n\n"
                        + "  {\n\n"
                        + "     \"field\": \"nome\",\n\n"
                        + "     \"message\": \"O campo 'id' é invalido\",\n\n"
                        + "  }\n\n"
                        + " ]\n\n"
                        + "}");

            }
        }

        return gson.toJson(products);
    }

   /**
     * Repassa o método save para válidar os nomes e garantir que eles não sejam iguais.
     * 
     * @param product O produto a ser salvo.
     * @throws ValidationErrorException Se ocorrer um erro de validação.
     */

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
    /**
     * Repassa o método deleteById e aplica as validações necessárias para os paramêtro Id.
     * 
     * @param id O ID do produto a ser excluído.
     * @throws ValidationErrorException Se ocorrer um erro de validação.
     */

    public void deleteObjectById(int id) throws ValidationErrorException {

        if (id < 1) {

            throw new ValidationErrorException("\n{\n\n"
                    + " \"code\": 400,\n\n"
                    + " \"status\": \"Bad Request\",\n\n"
                    + " \"messege\": \"O valor do campo 'id'é inválido\",\n\n"
                    + " \"details\": [\n\n"
                    + "  {\n\n"
                    + "     \"field\": \"nome\",\n\n"
                    + "     \"message\": \"O valor do campo 'id'é inválido\",\n\n"
                    + "  }\n\n"
                    + " ]\n\n"
                    + "}");

        } else {
            repository.deleteById(id);

        }

    }

    /**
     * Repassa o método updateById e aplica as validações necessárias para os paramêtros id e nome.
     * 
     * @param id O ID do produto a ser atualizado.
     * @param product O novo objeto Product contendo os dados atualizados do produto.
     * @throws ValidationErrorException Se ocorrer um erro de validação.
     */

    public void updateObjectById(int id, Product product) {

        if (id < 1) {

            throw new ValidationErrorException("\n{\n\n"
                    + " \"code\": 400,\n\n"
                    + " \"status\": \"Bad Request\",\n\n"
                    + " \"messege\": \"O valor do campo 'id'é inválido\",\n\n"
                    + " \"details\": [\n\n"
                    + "  {\n\n"
                    + "     \"field\": \"nome\",\n\n"
                    + "     \"message\": \"O valor do campo 'id'é inválido\",\n\n"
                    + "  }\n\n"
                    + " ]\n\n"
                    + "}");

        } else if (product.getName() == null) {

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
            repository.updateById(id, product);

        }

    }

}