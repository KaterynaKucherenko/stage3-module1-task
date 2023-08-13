package com.mjc.school.controller.impl;


import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.impl.ServiceModuleImpl;
import com.mjc.school.controller.ControllerFunc;

import java.util.List;

public class ControllerImplementation implements ControllerFunc<NewsDto> {
    Service<NewsDto> newsService;

    public ControllerImplementation() {

        this.newsService = ServiceModuleImpl.getINSTANCE();
    }


    @Override
    public NewsDto create(NewsDto newsDtoInput) {
        return newsService.create(newsDtoInput);
    }

    @Override
    public List<NewsDto> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsDto readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsDto update(NewsDto newsDtoInput) {
        return newsService.update(newsDtoInput);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}

