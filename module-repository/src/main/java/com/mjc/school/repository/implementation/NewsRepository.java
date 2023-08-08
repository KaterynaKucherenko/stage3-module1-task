package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasourse.DataSource;
import com.mjc.school.repository.model.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class NewsRepository implements Repository<NewsModel> {
    private final DataSource dataSource;

    LocalDateTime time = LocalDateTime.now();
    public NewsRepository(){
        this.dataSource = DataSource.getInstance();
    }
    @Override
    public NewsModel create(NewsModel newsModel) {
        dataSource.getNews().add(new NewsModel(dataSource.getLastNewsId()+1, newsModel.getTitle(), newsModel.getContent(), time, time, newsModel.getAuthorId()));

        return newsModel;

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
    public NewsModel update(NewsModel newsModel) {
        dataSource.getNews().set((int)(newsModel.getId()-1L),newsModel);
        //dataSource.getNews().add(newsModel);
    return  newsModel;

    }

    @Override
    public Boolean delete(Long id) {
        return  dataSource.getNews().remove(dataSource.getNewsId(id));
    }
}
