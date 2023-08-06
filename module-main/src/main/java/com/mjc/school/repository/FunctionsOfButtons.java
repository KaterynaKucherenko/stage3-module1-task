package com.mjc.school.repository;

import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.web.ConnectorImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionsOfButtons {
    public void createNews (Scanner scanner){
        System.out.println("Write the title of news:");
        String title = scanner.nextLine();
        System.out.println("Write the content of news:");
        String content = scanner.nextLine();
        System.out.println("Write the author ID of news:");
        long authorId = Long.parseLong(scanner.nextLine());
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
     System.out.println((connectorImplementation.create(new NewsDTO(title, content, authorId ))).toString());}

    public void readAll (){
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        //System.out.println
                List <NewsDTO> news = new ArrayList<>();
                news.addAll(connectorImplementation.readAll());
                news.forEach(a-> System.out.println(a.toString()));
    }
    public  void  readById(Scanner scanner){
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        System.out.println("Write the ID of news:");
        long idNews = Integer.parseInt(scanner.nextLine());
        System.out.println(connectorImplementation.readById(idNews).toString());
    }
    public void update (Scanner scanner){
        System.out.println("Write the title of news:");
        String title = scanner.nextLine();
        System.out.println("Write the content of news:");
        String content = scanner.nextLine();
        System.out.println("Write the author ID of news:");
        long authorId = Long.parseLong(scanner.nextLine());
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        System.out.println(connectorImplementation.update(new NewsDTO(title, content, authorId)).toString());
    }
    public void delete (Scanner scanner){
        System.out.println("Write the ID of news:");
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        long IDNews = Long.parseLong(scanner.nextLine());
        if(connectorImplementation.delete(IDNews) == true) {
            System.out.println("News with ID = " + IDNews + " was deleted ");
        }
        else {
            System.out.println("Nothing was deleted");
        }
    }
}
