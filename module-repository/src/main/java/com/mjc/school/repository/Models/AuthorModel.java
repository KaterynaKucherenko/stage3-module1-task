package com.mjc.school.repository.Models;

import java.util.Objects;

public class AuthorModel {
    private long id;
    private String name;
    public AuthorModel(long id, String name){
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

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;}
        if(obj == null|| obj.getClass()!=this.getClass()){
            return false;}
       AuthorModel am = (AuthorModel) obj;
        return id==am.id && (Objects.equals(name,am.name));
    }

    @Override
    public String toString() {
        return "id: "+ id +  ", name: " + name;
    }
}
