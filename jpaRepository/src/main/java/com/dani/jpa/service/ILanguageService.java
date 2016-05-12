package com.dani.jpa.service;

import java.util.List;

import com.dani.jpa.domain.Language;

public interface ILanguageService {

    Language createLanguage(String name);

    Language findByName(String name);

    List<Language> findByNames(List<String> name);

}
