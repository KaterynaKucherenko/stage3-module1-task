package com.mjc.school.service.DTO;

import com.mjc.school.service.ExceptionAndErrors.NewsNotFoundException;

import com.mjc.school.repository.NewsRepository.NewsRepository;
import com.mjc.school.service.Mapping.MapperNewsImpl;
import com.mjc.school.service.Validator.Validation;

import java.util.ArrayList;
import java.util.List;

public class ServiceModule implements OperationsDTO <NewsDTO>{
    private static ServiceModule INSTANCE;
    private NewsRepository newsRepository;
    private Validation validation= new Validation();

    public ServiceModule(){
        newsRepository=new NewsRepository();
    }
    public static ServiceModule getINSTANCE(){
        if(INSTANCE==null){
        INSTANCE = new ServiceModule();

        }
        return INSTANCE;
    }
    @Override
    public NewsDTO create(NewsDTO newsDTO) {
        validation.validate(newsDTO);
        return MapperNewsImpl.INSTANCE.newsToDTO(newsRepository.create(MapperNewsImpl.INSTANCE.DTOToNews(newsDTO)));
    }

    @Override
    public List<NewsDTO> readAll() {
        List<NewsDTO> result = new ArrayList<>();
        newsRepository.readAll().forEach(i -> result.add(MapperNewsImpl.INSTANCE.newsToDTO(i)));
        return result;
    }
    @Override
    public NewsDTO readById(Long id) throws NewsNotFoundException {
        NewsDTO newsDTO = MapperNewsImpl.INSTANCE.newsToDTO(newsRepository.readById(id));
        if (newsDTO==null) throw new NewsNotFoundException ("News with id: " + id + " is not found.");
        return newsDTO;
        }

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        validation.validate(newsDTO);
        return MapperNewsImpl.INSTANCE.newsToDTO(newsRepository.update(MapperNewsImpl.INSTANCE.DTOToNews(newsDTO)));
    }

    @Override
    public boolean delete(long id) throws NewsNotFoundException{
        boolean resultOfDelete = newsRepository.delete(id);
    if(resultOfDelete==false)throw new NewsNotFoundException ("News with id: " + id + " is not found. News cannot be deleted.");
        return resultOfDelete;
        }
    }

