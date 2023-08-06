package com.mjc.school.web;


import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.DTO.ServiceModule;

import java.util.List;

public class ConnectorImplementation implements ConnectorFunc<NewsDTO>{
    ServiceModule serviceModule;

    public ConnectorImplementation(){

    this.serviceModule = ServiceModule.getINSTANCE() ;}


    @Override
    public NewsDTO create(NewsDTO newsDTO) {
        return serviceModule.create(newsDTO);
    }

    @Override
    public List<NewsDTO> readAll() {
        return serviceModule.readAll();
    }

    @Override
    public NewsDTO readById(Long id) {
        return serviceModule.readById(id);
    }

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        return serviceModule.update(newsDTO);
    }

    @Override
    public boolean delete(long id) {
        return serviceModule.delete(id);
    }
}

