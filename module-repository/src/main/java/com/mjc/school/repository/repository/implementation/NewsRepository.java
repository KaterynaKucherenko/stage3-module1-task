package com.mjc.school.repository.repository.implementation;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.Models.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class NewsRepository implements RepositoryOperations<NewsModel> {
    private final DataSource dataSource;
    //LocalDateTime time = LocalDateTime.parse(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
    LocalDateTime time = LocalDateTime.now();
    public NewsRepository(){
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public NewsModel create(NewsModel nm) {
        if (nm != null){
        return new NewsModel(dataSource.getLastNewsId()+1, nm.getTitle(), nm.getContent(), time, time, dataSource.getLastNewsId()+1);
            }
    else{
    return null;}
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNews().stream().toList();
    }

    @Override
    public NewsModel readById(Long id) {
        return new NewsModel(dataSource.getNewsId(id-1).getId(), dataSource.getNewsId(id-1).getTitle(),dataSource.getNewsId(id-1).getContent(), dataSource.getNewsId(id-1).getCreateDate(), dataSource.getNewsId(id-1).getLastUpdateDate(), dataSource.getNewsId(id-1).getAuthorId());
    }

    @Override
    public NewsModel update(NewsModel nm) {
    return new NewsModel(nm.getId(), nm.getTitle(), nm.getContent(), time, time, nm.getAuthorId());}

    @Override
    public Boolean delete(long id) {
        return  dataSource.getNews().remove(dataSource.getNewsId(id));
    }
}
