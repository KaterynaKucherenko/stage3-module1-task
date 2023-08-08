package com.mjc.school.service.dto;
import javax.validation.constraints.*;
public class AuthorDto {
    private  Long id;
    @Min(value = 3,  message = "Name should not be less than 5")
    @Max(value = 15, message = "Name should not be greater than 255")
    private String name;

    public AuthorDto(){}

    public AuthorDto(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
