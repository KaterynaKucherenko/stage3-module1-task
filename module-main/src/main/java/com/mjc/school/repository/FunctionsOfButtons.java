package com.mjc.school.repository;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.web.connectorimpl.ConnectorImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionsOfButtons {
    public void createNews(Scanner scanner) {
        System.out.println("Write the  title of news:");
        String title = scanner.nextLine();
        System.out.println("Write the content of news:");
        String content = scanner.nextLine();
        System.out.println("Write the author ID of news:");
        Long authorId = Long.parseLong(scanner.nextLine());
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();

        connectorImplementation.create(new NewsDto(title, content, authorId));
    }

    public void readAll() {
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        List<NewsDto> news = new ArrayList<>();
        news.addAll(connectorImplementation.readAll());
        news.forEach(a -> System.out.println(a.toString()));
    }

    public void readById(Scanner scanner) {
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        System.out.println("Write the ID of news:");
        Long idNews = Long.parseLong(scanner.nextLine());
        System.out.println(connectorImplementation.readById(idNews).toString());
    }

    public void update(Scanner scanner) {
        System.out.println("Write the ID of news:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Write the title of news:");
        String title = scanner.nextLine();
        System.out.println("Write the content of news:");
        String content = scanner.nextLine();
        System.out.println("Write the author ID of news:");
        Long authorId = Long.parseLong(scanner.nextLine());
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();

        System.out.println(connectorImplementation.update(new NewsDto(id, title, content, authorId)).toString());
    }

    public void delete(Scanner scanner) {
        System.out.println("Write the ID of news:");
        ConnectorImplementation connectorImplementation = new ConnectorImplementation();
        Long IDNews = Long.parseLong(scanner.nextLine());
        if (connectorImplementation.delete(IDNews)) {
            System.out.println("News with ID = " + IDNews + " was deleted ");
        } else {
            System.out.println("Nothing was deleted");
        }
    }
}
