package com.tronin.spring.mvc.services;

import java.util.List;

public interface IDAO<T, K>{

    boolean  create(T entity);
    boolean deleteById(K id);
    T getEntityById(K id);
    T update(T entity, K id);
    List<T> getAll();



}
