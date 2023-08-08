package com.mjc.school.repository;

import com.mjc.school.web.connectorimpl.ConnectorImplementation;

import java.util.Scanner;

public class Input {
    private Scanner scanner;
    ConnectorImplementation connectorImplementation;
    FunctionsOfButtons functionsOfButtons = new FunctionsOfButtons();
    public Input() {
       run();

    }
    public void run(){
        connectorImplementation = new ConnectorImplementation();
        while (true){
            System.out.println("Choose one of the command:" + "\n" + "1 - create news" + "\n" + "2 - read all news" + "\n" + "3 - read news by ID" + "\n" + "4 - update news" + "\n" + "5 - delete news by ID"+ "\n" +"0 - to menu");
            scanner = new Scanner(System.in);
            String numberOfCommand =scanner.nextLine();
        switch ( numberOfCommand) {
            case "1":
                functionsOfButtons.createNews(scanner);
                break;
            case "2":
                functionsOfButtons.readAll();
                break;
            case "3":
                functionsOfButtons.readById(scanner);
                break;
            case "4":
                functionsOfButtons.update(scanner);
                break;
            case "5":
                functionsOfButtons.delete(scanner);
                break;
            case "0":

                System.exit(0);

                break;


        }
        }



    }


}




