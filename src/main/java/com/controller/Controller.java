package main.java.com.controller;
import main.java.com.product.handler.ProductHandler;

public class Controller {

    final private ProductHandler productHandler;

    public Controller() {
        this.productHandler = new ProductHandler();
    }

    public void checkOption(int option) {
        /*
        todo: coletar as informações do produto para poder criar um produto
        esse switch ficaria melhor na classe Application, pq dentro do Controller posso pegar
        métodos específicos
         */
        switch(option) {
            case 1:
                this.productHandler.list();
                break;
            case 2:
                //this.productHandler.findById();
                break;
            case 3:
                //this.productHandler.create();
                break;
            case 4:
                //this.productHandler.update();
                break;
            case 5:
                //this.productHandler.delete();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
