package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Survey;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.SurveyRepo;
import com.nocountry.nocountry.services.ISurveyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SurveyServiceImpl extends CRUDServiceImpl<Survey, UUID> implements ISurveyService {

    private final SurveyRepo repo;

    public SurveyServiceImpl(SurveyRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Survey, UUID> getRepo() {
        return repo;
    }
}
