package com.example.repository;

import java.sql.*;
import java.util.List;

import com.example.entities.Product;

import java.util.ArrayList;

public class ProductRepository extends Repository {
   

    
    /** 
     * Metódo para mostrar todos os produtos do banco de dados
     *@return Uma lista contendo todos os produtos do banco de dados.
     */
    public List<Product> findAll() {

        try {
            final Connection connection = getConnection();

            final String sql = "SELECT * FROM product";
            final PreparedStatement statement = connection.prepareStatement(sql);

            final ResultSet resultSet = statement.executeQuery();

            final List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setValue(resultSet.getLong("value"));
                product.setDescription(resultSet.getString("description"));
                products.add(product);
            }
            return products;

        } catch (Exception e) { 
            throw new RuntimeException(e);
        }

    }

   
    /**
     * Método para achar um produto diretamente pelo seu Id, retorna uma lista de Objetos Product.
     * @param id O ID do produto a ser pesquisado.
     * @return Uma lista contendo o(s) produto(s) correspondente(s) ao ID fornecido.
     */
    public List<Product> findById(final int id) {

        try {
            final Connection connection = getConnection();

            final String sql = "SELECT * FROM product WHERE id = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();

            final List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setValue(resultSet.getLong("value"));
                product.setDescription(resultSet.getString("description"));
                products.add(product);
            }
            return products;

        } catch (Exception e) { 
            throw new RuntimeException(e);
        }

    }

    
    /**
     * Método para criar/salvar um produto no banco de dados no qual precisa receber um objeto do tipo Product.
     * @param product O produto a ser salvo no banco de dados.
     */
    public void save(Product product) {
        try {
            final Connection connection = getConnection();
            final String sql = "INSERT INTO product (name, value, description) VALUES (?, ?, ?)";
            final PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getValue());
            statement.setString(3, product.getDescription());
            statement.executeUpdate();
            
        } catch (Exception e) { 
            throw new RuntimeException(e);

        }

    }

    /**
     * Método para deletar utilizando somente o Id do objeto Product.
     *  @param id O ID do produto a ser excluído.
     */
    public void deleteById(final int id) {
        try {
            final Connection connection = getConnection();
            final String sql = "DELETE FROM product WHERE id = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (Exception e) { 
            throw new RuntimeException(e);

        }
    }

    /**
     * Atualiza um objeto selecionando o Id do objeto alvo, logo em seguida os dados atualizados que o usuário deseja sobescrever
     * @param id O ID do produto a ser atualizado.
     * @param product O novo objeto Product contendo os dados atualizados do produto.
     */
    public void updateById(final int id, Product product) {
        try {
            final Connection connection = getConnection();
            final String sql = "UPDATE product SET name = ?, value = ?, description = ? WHERE id = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getValue());
            statement.setString(3, product.getDescription());
            statement.setInt(4, id);
            statement.executeUpdate();
            

        } catch (Exception e) { 
            throw new RuntimeException(e);

        }
    }
}
