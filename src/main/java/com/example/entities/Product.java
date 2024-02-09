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
        + "\" value\": " + String.format("%.2f", value) + ",\n\n"
        + "}\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
