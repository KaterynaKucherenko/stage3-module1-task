package com.mjc.school.repository.repository.implementation;

import java.util.List;

public interface RepositoryOperations<T>{
    T create (T t);
    List<T> readAll();
    T readById (Long id);
    T update (T t);
    Boolean delete (Long id);
}
