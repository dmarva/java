package com.dani.jpa.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.dani.jpa.domain.User;

public interface IUserService {

    User createUser(String name, String surname, Date birthDate, String gender, List<String> languages);

    User getUserByNif(String nif);

    Page<User> getPaginatedUsersKnowingAnyLanguage(int page, int size, List<String> languages);

    List<User> getUsersKnowingLanguage(String language);

}
