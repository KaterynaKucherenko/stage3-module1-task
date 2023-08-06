package com.mjc.school.repository.NewsRepository;

import java.util.List;

public interface RepositoryOperations<T>{
    T create (T t);
    List<T> readAll();
    T readById (Long id);
    T update (T t);
    boolean delete (long id);
}
