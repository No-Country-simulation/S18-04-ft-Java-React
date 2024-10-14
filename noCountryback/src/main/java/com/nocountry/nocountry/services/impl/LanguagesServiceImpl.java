package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Languages;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.LanguagesRepo;
import com.nocountry.nocountry.services.ILanguagesService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LanguagesServiceImpl extends CRUDServiceImpl<Languages, UUID> implements ILanguagesService {

    private final LanguagesRepo repo;

    public LanguagesServiceImpl(LanguagesRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Languages, UUID> getRepo() {
        return repo;
    }
}
