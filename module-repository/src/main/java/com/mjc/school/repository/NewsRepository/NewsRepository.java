package com.mjc.school.repository.NewsRepository;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.Models.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class NewsRepository implements RepositoryOperations<NewsModel> {
    private DataSource dataSource;
    //LocalDateTime time = LocalDateTime.parse(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
    LocalDateTime time = LocalDateTime.now();
    public NewsRepository(){
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public NewsModel create(NewsModel nm) {
        if (nm != null){
        NewsModel newNewsModel = new NewsModel(dataSource.getLastNewsId()+1, nm.getTitle(), nm.getContent(), time, time, dataSource.getLastNewsId()+1);
            return newNewsModel;}
    else{
    return null;}
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNews().stream().toList();
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource.getNewsId(id);
    }

    @Override
    public NewsModel update(NewsModel nm) {
         NewsModel updatedNewsModel = new NewsModel(nm.getId(), nm.getTitle(), nm.getContent(), time, time, nm.getAuthorId());
    return updatedNewsModel;}

    @Override
    public boolean delete(long id) {
        return  dataSource.getNews().remove(dataSource.getNewsId(id));
    }
}
