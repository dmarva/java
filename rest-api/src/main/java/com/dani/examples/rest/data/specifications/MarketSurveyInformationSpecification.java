package com.dani.examples.rest.data.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dani.examples.rest.domain.MarketSurveyInformation;
import com.dani.examples.rest.domain.MarketSurveyInformation_;

public class MarketSurveyInformationSpecification {

    public static Specification<MarketSurveyInformation> withUrn(final String urn) {
	return new Specification<MarketSurveyInformation>() {

	    @Override
	    public Predicate toPredicate(Root<MarketSurveyInformation> root, CriteriaQuery<?> arg1,
		    CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(MarketSurveyInformation_.marketSurveyUrn), urn);
	    }
	};
    }

}
