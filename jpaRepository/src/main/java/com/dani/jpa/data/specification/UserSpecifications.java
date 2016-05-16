package com.dani.jpa.data.specification;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dani.jpa.domain.Gender;
import com.dani.jpa.domain.Language;
import com.dani.jpa.domain.Language_;
import com.dani.jpa.domain.User;
import com.dani.jpa.domain.User_;

public class UserSpecifications {

    public static Specification<User> withName(final String name) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(User_.name), name);
	    }
	};
    }

    public static Specification<User> withSurname(final String surname) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(User_.surname), surname);
	    }
	};
    }

    public static Specification<User> withBirthDate(final Date date) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(User_.birthDate), date);
	    }
	};
    }

    public static Specification<User> withLanguage(final String language) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		ListJoin<User, Language> languageJoin = root.join(User_.languages);
		return criteriaBuilder.equal(languageJoin.get(Language_.name), language);
	    }
	};
    }

    public static Specification<User> withEveryLanguage(final List<Language> languages) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		return root.get(User_.languages).in(languages);
	    }
	};
    }

    public static Specification<User> withGender(final Gender gender) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(User_.gender), gender);
	    }
	};
    }

    public static Specification<User> withNif(final String nif) {

	return new Specification<User>() {

	    @Override
	    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(User_.nif), nif);
	    }
	};
    }
}
