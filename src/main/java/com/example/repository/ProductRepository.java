package com.example.repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class ProductRepository extends Repository {
    // todo: fazer um metodo findAll

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

        } catch (Exception e) { // todo: tratar a exceção corretamente
            throw new RuntimeException(e);
        }

    }

    // Método de busca por id: **DUVIDA: findById ou findByName?
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

        } catch (Exception e) { // todo: tratar a exceção corretamente
            throw new RuntimeException(e);
        }

    }

    // Salva um novo produto no banco de dados
    public void save(Product product) {
        try {
            final Connection connection = getConnection();
            final String sql = "INSERT INTO product (name, value, description) VALUES (?, ?, ?)";
            final PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getValue());
            statement.setString(3, product.getDescription());
            statement.executeUpdate();
        } catch (Exception e) { // todo: tratar a exceção corretamente
            throw new RuntimeException(e);

        }

    }

    public void deleteById(final int id) {
        try {
            final Connection connection = getConnection();
            final String sql = "DELETE FROM product WHERE id = ?"; // joao sem acento não pega no ilike
            final PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.executeUpdate();
          

        } catch (Exception e) { // todo: tratar a exceção corretamente
            throw new RuntimeException(e);

        }
    }
}
