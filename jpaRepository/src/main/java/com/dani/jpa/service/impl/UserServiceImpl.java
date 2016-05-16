package com.dani.jpa.service.impl;

import static com.dani.jpa.data.specification.UserSpecifications.withEveryLanguage;
import static com.dani.jpa.data.specification.UserSpecifications.withLanguage;
import static com.dani.jpa.data.specification.UserSpecifications.withNif;
import static com.dani.jpa.service.helper.PageableHelper.getPageableFromPageAndSize;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dani.jpa.data.repository.IUserRepository;
import com.dani.jpa.domain.Gender;
import com.dani.jpa.domain.User;
import com.dani.jpa.service.ILanguageService;
import com.dani.jpa.service.IUserService;

public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ILanguageService languageService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public User createUser(final String name, final String surname, final Date birthDate, final String gender,
	    final List<String> languages) {
	User user = new User();
	user.setName(name);
	user.setSurname(surname);
	user.setBirthDate(birthDate);
	user.setGender(Gender.valueOf(gender));
	user.setLanguages(languageService.findByNames(languages));

	return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public User getUserByNif(final String nif) {
	return userRepository.findOne(withNif(nif));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public List<User> getUsersKnowingLanguage(final String language) {
	return userRepository.findAll(withLanguage(language));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public Page<User> getPaginatedUsersKnowingAnyLanguage(final int page, final int size, List<String> languages) {
	Pageable pageable = getPageableFromPageAndSize(page, size);
	return userRepository.findAll(withEveryLanguage(languageService.findByNames(languages)), pageable);
    }
}
