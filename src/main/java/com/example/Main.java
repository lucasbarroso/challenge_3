package com.example;

import com.example.repository.Repository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Repository conn= new Repository();
        conn.getConnection();
        
    }
}