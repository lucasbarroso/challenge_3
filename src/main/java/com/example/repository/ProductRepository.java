package com.example.repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class ProductRepository extends Repository{
    public List<Product> findById(final int id){

        try{
            Connection connection = getConnection();
            
            String sql = "SELECT * FROM product WHERE id = ?";
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

            

        }catch (Exception e) { //todo: tratar a exceção corretamente
            throw new RuntimeException(e);
        } 


    }
    
}
