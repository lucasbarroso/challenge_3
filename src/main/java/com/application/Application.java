package main.java.com.application;

import main.java.com.controller.Controller;
import java.util.Scanner;

public class Application {

    Scanner sc = new Scanner(System.in);

    final private Controller controller;

    public Application() {
        this.controller = new Controller();

    }

    public void run() {
        System.out.println("rodando");
        this.controller.menu();
        int option = sc.nextInt();
        this.controller.checkOption(option);

    }
}
