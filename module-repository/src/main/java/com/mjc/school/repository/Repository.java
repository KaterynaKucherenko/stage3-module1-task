package com.mjc.school.repository;

import java.util.List;

public interface Repository<T>{
    T create (T t);
    List<T> readAll();
    T readById (Long id);
    T update (T t);
    Boolean delete (Long id);
}
