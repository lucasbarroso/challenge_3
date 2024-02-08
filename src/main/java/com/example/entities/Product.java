package com.example.entities;

public class Product { //classe só para testar o crude, apagar após os testes

    private int id;
    private String name;
    private String description;
    private double value;

    public Product() {
    }

    public Product(String name, String description, double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\n{\n\n"
        + "\"id\": " + id + ",\n\n"
        + "\"name\": " + name + ",\n\n"
        + "\"description\": " + description + ",\n\n"
        + "\" value\": " + String.format("%.2f", description) + ",\n\n"
        + "},\n";
    }
}
