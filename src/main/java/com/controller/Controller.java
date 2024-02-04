package main.java.com.controller;
import main.java.com.product.handler.ProductHandler;

public class Controller {

    public void checkOption(int option) {
        switch(option) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
