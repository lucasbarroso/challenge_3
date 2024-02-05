package com.example.repository;
import java.sql.*;

public class Repository {
    private static String host ="";
    private static final String URL = "jdbc:postgresql://"+ host+ ":5432/postgres"; 
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static Connection con;
    
    public Connection getConnection() {
        try {
            
            if(con == null || con.isClosed()){
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }
            System.out.println("deu certo?");
            return con;
            

        } catch (Exception e) { //todo: falta tratar esta e outras exceções.
            throw new RuntimeException(e);
        }
    }
}
