package com.mjc.school.web;

import java.util.List;

public interface ConnectorFunc <T> {
    T create (T t);
    List<T> readAll();
    T readById (Long id);
    T update (T t);
    boolean delete (long id);
}
