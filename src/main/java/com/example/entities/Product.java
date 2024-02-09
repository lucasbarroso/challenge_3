package com.example.entities;

/**
 * Classe para objetos do tipo Product, onde serão contidos os valores,Gets e
 * Setters, .
 * 
 * @author Lucas Barroso
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private double value;

    public Product() {
    }

    /**
     * Construtor da classe Project sem o Id, pois o PostgreSQL será responsável
     * pelo auto-incremento do atributo id.
     * 
     * @param name        O nome do produto.
     * @param description A descrição do produto.
     * @param value       O valor do produto.
     */

    public Product(String name, String description, double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    /**
     * Calcula o código de hash do produto.
     * 
     * @return O código de hash do produto.
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * Verifica se outro objeto é igual a este produto.
     * 
     * @param obj O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */

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

    /**
     * Retorna uma representação em string do produto.
     * 
     * @return Uma representação em string do produto.
     */
    
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
