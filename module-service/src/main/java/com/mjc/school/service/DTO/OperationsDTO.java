package com.mjc.school.service.DTO;

import java.util.List;

public interface OperationsDTO <T> {
    T create (T t);
    List<T> readAll();
    T readById (Long id);
    T update (T t);
    boolean delete (long id);

}
