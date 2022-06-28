package com.fai.springboot.dao;

import java.util.List;

public interface CrudDao<T> {

    List<T> list();

    int save(T entity);

    T listById(int id);

    boolean update(T entity);

    boolean deleteById(int id);

}
