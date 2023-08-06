package com.mjc.school.service.Mapping;

import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.repository.Models.NewsModel;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface MapperNews {
    MapperNews INSTANCE = Mappers.getMapper(MapperNews.class);

    NewsDTO newsToDTO (NewsModel newsModel);
    @Mapping(target = "createDate", ignore = true)

    @Mapping(target = "lastUpdateDate", ignore = true)

    NewsModel DTOToNews (NewsDTO newsDTO);

}
