package com.mjc.school.repository.datasourse;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static DataSource INSTANCE ;

    private List<AuthorModel> authors;
    private List<NewsModel> news;
    private List<String> content;
    private List<String> title;
    private  Long counter =1L;
    private  Long counterForAuthor =1L;



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
        this.authors = new ArrayList<>();
    try (BufferedReader readAuth = new BufferedReader(new FileReader(PATH_TO_AUTHOR))) {
        String line;
        while ((line=readAuth.readLine())!=null){
            String sl = line;
            AuthorModel authorModel = new AuthorModel(this.counterForAuthor++, sl);
            authors.add(authorModel);
        }}
    catch (Exception e) {
        e.printStackTrace();
    }
return authors;
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
        this.news=new ArrayList<>();
    for(int i = 0; i<title.size(); i++){
        LocalDateTime time = LocalDateTime.now();
        Long authId = authors.get(i).getId();
        NewsModel newsModel= new NewsModel(this.counter++, title.get(i), content.get(i), time, time, authId);;
        news.add(newsModel);
    }
    return news;
    }

    public List<NewsModel> getNews() {
        return news;
    }
    public NewsModel getNewsId(Long id){
        if(id <=news.size() && id>0){
            int it = id.intValue();
        return news.get(it);
    }
    else {
            return null;
        }}
    public Long getLastNewsId(){
       Long id= Long.valueOf(news.size());

        return id;
    }

}