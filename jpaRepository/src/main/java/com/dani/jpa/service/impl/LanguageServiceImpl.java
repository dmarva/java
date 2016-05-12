package com.dani.jpa.service.impl;

import static com.dani.jpa.data.specification.LanguageSpecifications.withName;
import static com.dani.jpa.data.specification.LanguageSpecifications.withNames;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dani.jpa.data.repository.ILanguageRepository;
import com.dani.jpa.domain.Language;
import com.dani.jpa.service.ILanguageService;

public class LanguageServiceImpl implements ILanguageService {

    @Autowired
    private ILanguageRepository languageRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Language createLanguage(final String name) {
        Language language = new Language();
        language.setName(name);

        return languageRepository.save(language);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public Language findByName(final String name) {

        return languageRepository.findOne(where(withName(name)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public List<Language> findByNames(final List<String> name) {

        return languageRepository.findAll(where(withNames(name)));
    }
}
