package com.nocountry.nocountry.services;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<T,ID>{
    T findById(ID id);
    T create(T t);
    T updateById(T t, ID id);
    void delete(ID id);
    List<T> getAll();
    Page<T> findAllPage(int page, int size, String sortField, String sortOrder);
}
