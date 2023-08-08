package com.mjc.school.service.mapping;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.repository.model.NewsModel;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface MapperNewsImpl {
    MapperNewsImpl INSTANCE = Mappers.getMapper(MapperNewsImpl.class);

    NewsDto newsToDto (NewsModel newsModel);
    @Mapping(target = "createDate", ignore = true)

    @Mapping(target = "lastUpdateDate", ignore = true)

    NewsModel DtoToNews(NewsDto newsDto);

}
