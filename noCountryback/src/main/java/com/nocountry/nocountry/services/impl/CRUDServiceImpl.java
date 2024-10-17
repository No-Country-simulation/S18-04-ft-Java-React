package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.services.ICRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public abstract class  CRUDServiceImpl<T,ID> implements ICRUDService<T,ID> {

    protected abstract GenericRepo<T , ID> getRepo();

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new NotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public T create(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Cannot create a null entity");
        }
        return getRepo().save(t);
    }

    @Override
    public T updateById(T t, ID id) {
        return getRepo().updateById(t,id).orElseThrow(() -> new NotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) {
        if (!getRepo().existsById(id)) {
            throw new NotFoundException("ID NOT FOUND: " + id);
        }
        getRepo().deleteById(id);
    }

    @Override
    public List<T> getAll() {
        return getRepo().findAll();
    }

    @Override
    public Page<T> findAllPage(int page, int size, String sortField, String sortOrder) {
        validateSortField(sortField);
        Pageable pageable = PageRequest.of(page, size, getSort(sortField, sortOrder));
        return getRepo().findAll(pageable);
    }

    private Sort getSort(String sortField, String sortOrder) {
        Sort sort = Sort.by(sortField);
        if (sortOrder.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        return sort;
    }

    private void validateSortField(String sortField) {
        List<String> allowedSortFields = List.of("eventName", "eventDescription", "eventParticipant", "eventDateStart", "eventDateEnd");
        if (!allowedSortFields.contains(sortField)) {
            throw new IllegalArgumentException("Invalid sort field: " + sortField);
        }
    }
}
