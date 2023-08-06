package com.mjc.school.service.DTO;
import javax.validation.constraints.*;
public class AuthorDTO {
    private  long id;
    @Min(value = 3,  message = "Name should not be less than 5")
    @Max(value = 15, message = "Name should not be greater than 255")
    private String name;

    public AuthorDTO(){}

    public AuthorDTO(long id, String name){
        this.id=id;
        this.name=name;
    }

    public long getId() {
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
