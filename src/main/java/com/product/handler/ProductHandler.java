package main.java.com.product.handler;

import main.java.com.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductHandler {

    List<Product> products = new ArrayList<Product>();

    public ProductHandler() {
        this.products = new ArrayList<Product>();
    }

    public void list() {
        System.out.println("lista de produtos");
    }

    public void findById(int id) {
        System.out.println("buscar id");
    }

    public void create(String name, String description, double value) {
        System.out.println("criando produto");
    }

    public void update(int id, String attribute, String value) {
        System.out.println("atualizando");
    }

    public void delete(int id) {
        System.out.println("deletando");
    }
}
