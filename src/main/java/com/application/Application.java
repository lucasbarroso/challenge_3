package main.java.com.application;

import main.java.com.controller.Controller;
import main.java.com.application.menu.Menu;
import java.util.Scanner;


public class Application {

    Scanner sc = new Scanner(System.in);

    final private Controller controller;

    public Application() {
        this.controller = new Controller();
    }

    public void run() {
        System.out.println("rodando");
        Menu.showMenu(); //EXIBE OPÇÕES DO MENU
        int option = sc.nextInt(); //COLETA OPÇÃO DIGITADA PELO USUÁRIO
        this.controller.checkOption(option); //ENVIA PRA CLASSE CONTROLLER EXECUTAR A OPÇÃO SELECIONADA

    }
}
