package com.example.repository;
import java.sql.*;

public abstract class Repository {
    private static String host =System.getenv("TESTEPHP_POSTGRES_HOST");
    private static final String URL = "jdbc:postgresql://"+ host+ ":5432/postgres"; //
    private static final String USERNAME = "";
    private static final String PASSWORD = System.getenv("TESTEPHP_POSTGRES_PASSWORD");;
    private static Connection con;
    
    protected Connection getConnection() {
        try {
            
            if(con == null || con.isClosed()){
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }
            return con;
            

        } catch (Exception e) { //todo: falta tratar esta e outras exceções.
            throw new RuntimeException(e);
        }
    }
}
