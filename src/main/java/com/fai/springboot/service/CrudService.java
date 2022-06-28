package com.fai.springboot.service;

import java.util.List;

public interface CrudService<T> {

    List<T> list();

    int save(T entity);

    T listById(int id);

    boolean update(T entity);

    boolean deleteById(int id);
}
