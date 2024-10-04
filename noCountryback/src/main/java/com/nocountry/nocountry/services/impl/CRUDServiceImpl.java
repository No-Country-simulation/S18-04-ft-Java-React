package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.services.ICRUDService;

import java.util.List;

public abstract class  CRUDServiceImpl<T,ID> implements ICRUDService<T,ID> {

    protected abstract GenericRepo<T , ID> getRepo();

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow();
    }

    @Override
    public T create(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) {
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }

    @Override
    public List<T> getAll() {
        return getRepo().findAll();
    }
}
