package com.dani.jpa.data.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dani.jpa.domain.Language;
import com.dani.jpa.domain.Language_;

public class LanguageSpecifications {

    public static Specification<Language> withName(final String name) {

        return new Specification<Language>() {

            @Override
            public Predicate toPredicate(Root<Language> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Language_.name), name);
            }
        };
    }

    public static Specification<Language> withNames(final List<String> languages) {

        return new Specification<Language>() {

            @Override
            public Predicate toPredicate(Root<Language> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {
                return root.get(Language_.name).in(languages);
            }
        };
    }
}
