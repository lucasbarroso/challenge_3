package main.java.com.controller;
import main.java.com.product.handler.ProductHandler;

public class Controller {

    public void checkOption(int option) {
        switch(option) {
            case 1:
                System.out.println("1- Listando produtos");
                break;
            case 2:
                System.out.println("2- Buscando produto");
                break;
            case 3:
                System.out.println("3- Criando produto");
                break;
            case 4:
                System.out.println("4- Atualizando produto");
                break;
            case 5:
                System.out.println("5- Deletando produto");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
