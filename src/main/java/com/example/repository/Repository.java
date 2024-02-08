package com.example.repository;

import java.sql.*;

public abstract class Repository {
    private static String host ="db.bqhhbvaejpgxsepjzkbc.supabase.co";
    private static final String URL = "jdbc:postgresql://"+ host+ ":5432/postgres"; 
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "marquinhos.123";
    private static Connection con;
    public Connection getConnection() {
        try {

            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }

            return con;

        } catch (Exception e) { // todo: falta tratar esta e outras exceções.
            throw new RuntimeException(e);
        }
    }
}
