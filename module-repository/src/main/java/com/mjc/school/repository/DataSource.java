package com.mjc.school.repository;

import com.mjc.school.repository.Models.AuthorModel;
import com.mjc.school.repository.Models.NewsModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static DataSource INSTANCE ;

    private List<AuthorModel> authors;
    private List<NewsModel> news;
    private List<String> content;
    private List<String> title;
    private long counter = 1;


    private final String PATH_TO_CONTENT = "module-repository/src/main/resources/ content.txt";
    private final String PATH_TO_AUTHOR = "module-repository/src/main/resources/author.txt";
    private final String PATH_TO_TITLE = "module-repository/src/main/resources/news.txt";

    public DataSource(){
        init();
    }

    private void init() {
        this.authors=readAuthor();
        readContent();
        readTitle();
        this.news=createNewsModel();
    }
    public static DataSource getInstance(){
        if(INSTANCE==null){
            INSTANCE = new DataSource();
        }
        return INSTANCE;
    }


    public  List<AuthorModel> readAuthor() {
        List<AuthorModel> result = new ArrayList<>();
    try (BufferedReader readAuth = new BufferedReader(new FileReader(PATH_TO_AUTHOR))) {
        String line;
        while ((line=readAuth.readLine())!=null){
            String sl = line;
            AuthorModel authorModel = new AuthorModel(counter++, sl);
            result.add(authorModel);
        }}
    catch (Exception e) {
        e.printStackTrace();
    }
return result;
}

    public void readContent() {
        content=new ArrayList<>();
        try (BufferedReader readContent = new BufferedReader(new FileReader(PATH_TO_CONTENT))) {
            String line;
            while ((line=readContent.readLine())!=null){
            this.content.add(line);
            }}
         catch (Exception e) {
             e.printStackTrace();
         }
    }
    public void readTitle() {
        title=new ArrayList<>();
        try (BufferedReader readContent = new BufferedReader(new FileReader(PATH_TO_TITLE))) {
            String line;
            while ((line=readContent.readLine())!=null){
                this.title.add(line);
            }}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized List<NewsModel> createNewsModel() {
        List<NewsModel> result = new ArrayList<>();
    for(int i = 0; i<title.size(); i++){
       // LocalDateTime time = LocalDateTime.parse(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
        LocalDateTime time = LocalDateTime.now();
        NewsModel newsModel = new NewsModel(i+1, title.get(i), content.get(i), time, time, authors.get(i).getId());
        result.add(newsModel);
    }
    return result;
    }

    public List<NewsModel> getNews() {
        return news;
    }
    public NewsModel getNewsId(long id){
        if(id <news.size() && id>0){
        return news.get((int)id);
    }
    else {
            return null;
        }}
    public int getLastNewsId(){
       return news.size();
    }

}