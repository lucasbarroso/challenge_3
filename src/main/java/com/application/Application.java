package main.java.com.application;

import main.java.com.controller.Controller;

public class Application {

    final private Controller controller;

    public Application() {
        this.controller = new Controller();

    }

    public void run() {
        System.out.println("rodando");
        this.controller.options();


    }
}
