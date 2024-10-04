package com.nocountry.nocountry.services;

import java.util.List;

public interface ICRUDService<T,ID>{
    T findById(ID id);
    T create(T t);
    T update(T t);
    void delete(ID id);
    List<T> getAll();
}
