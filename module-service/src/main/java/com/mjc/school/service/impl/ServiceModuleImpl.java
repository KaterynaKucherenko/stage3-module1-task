package com.mjc.school.service.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.ExceptionAndErrors.NewsNotFoundException;

import com.mjc.school.repository.implementation.NewsRepository;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.Service;
import com.mjc.school.service.validator.Validation;
import com.mjc.school.service.mapping.MapperNewsImpl;

import java.util.ArrayList;
import java.util.List;

public class ServiceModuleImpl implements Service<NewsDto> {
    private static ServiceModuleImpl INSTANCE;
    private final Repository<NewsModel> newsRepository;
    private final Validation validation= new Validation();

    public ServiceModuleImpl(){
        newsRepository=new NewsRepository();
    }
    public static ServiceModuleImpl getINSTANCE(){
        if(INSTANCE==null){
        INSTANCE = new ServiceModuleImpl();

        }
        return INSTANCE;
    }
    @Override
    public NewsDto create(NewsDto newsDto) {
        validation.validate(newsDto);
        return MapperNewsImpl.INSTANCE.newsToDto(newsRepository.create(MapperNewsImpl.INSTANCE.DtoToNews(newsDto)));
    }

    @Override
    public List<NewsDto> readAll() {
        List<NewsDto> result = new ArrayList<>();
        newsRepository.readAll().forEach(i -> result.add(MapperNewsImpl.INSTANCE.newsToDto(i)));
        return result;
    }
    @Override
    public NewsDto readById(Long id) throws NewsNotFoundException {
        NewsDto newsDto = MapperNewsImpl.INSTANCE.newsToDto(newsRepository.readById(id));
        if (newsDto==null) throw new NewsNotFoundException ("News with id: " + id + " is not found.");
        return newsDto;
        }

    @Override
    public NewsDto update(NewsDto newsDto) {
        validation.validate(newsDto);
        return MapperNewsImpl.INSTANCE.newsToDto(newsRepository.update(MapperNewsImpl.INSTANCE.DtoToNews(newsDto)));
    }

    @Override
    public boolean delete(Long id) throws NewsNotFoundException{
        boolean resultOfDelete = newsRepository.delete(id);
    if(resultOfDelete==false)throw new NewsNotFoundException ("News with id: " + id + " is not found. News cannot be deleted.");
        return resultOfDelete;
        }
    }

