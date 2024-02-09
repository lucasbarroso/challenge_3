package com.example.repository;

import java.sql.*;

public abstract class Repository {
    private static String host ="db.bqhhbvaejpgxsepjzkbc.supabase.co";
    private static final String URL = "jdbc:postgresql://"+ host+ ":5432/postgres"; 
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "marquinhos.123";
    private static Connection con;
    
    /** 
     * Método para obter conexão com o banco de dados.
     * @return Connection
     */
    public Connection getConnection() {
        try {

            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }

            return con;

        } catch (Exception e) { 
            throw new RuntimeException(e);
        }
    }
}
