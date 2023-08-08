package com.mjc.school.web.connectorimpl;


import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.impl.ServiceModuleImpl;
import com.mjc.school.web.ConnectorFunc;

import java.util.List;

public class ConnectorImplementation implements ConnectorFunc<NewsDto> {
    Service<NewsDto> serviceModule;

    public ConnectorImplementation() {

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
    public boolean delete(Long id) {
        return serviceModule.delete(id);
    }
}

