package com.mjc.school.controller.impl;


import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.impl.ServiceModuleImpl;
import com.mjc.school.controller.ControllerFunc;

import java.util.List;

public class ControllerImplementation implements ControllerFunc<NewsDto> {
    Service<NewsDto> serviceModule;

    public ControllerImplementation() {

        this.serviceModule = ServiceModuleImpl.getINSTANCE();
    }


    @Override
    public NewsDto create(NewsDto newsDto) {
        return serviceModule.create(newsDto);
    }

    @Override
    public List<NewsDto> readAll() {
        return serviceModule.readAll();
    }

    @Override
    public NewsDto readById(Long id) {
        return serviceModule.readById(id);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        return serviceModule.update(newsDto);
    }

    @Override
    public Boolean delete(Long id) {
        return serviceModule.delete(id);
    }
}

