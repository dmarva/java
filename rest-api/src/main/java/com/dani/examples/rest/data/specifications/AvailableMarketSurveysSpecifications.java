package com.dani.examples.rest.data.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dani.examples.rest.domain.AvailableMarketSurveys;
import com.dani.examples.rest.domain.AvailableMarketSurveysId;
import com.dani.examples.rest.domain.AvailableMarketSurveysId_;
import com.dani.examples.rest.domain.AvailableMarketSurveys_;
import com.dani.examples.rest.domain.MarketSurveyInformation;

public class AvailableMarketSurveysSpecifications {

    public static Specification<AvailableMarketSurveys> withMarketSurveyInformationUrn(
	    final MarketSurveyInformation urn) {
	return new Specification<AvailableMarketSurveys>() {

	    @Override
	    public Predicate toPredicate(Root<AvailableMarketSurveys> root, CriteriaQuery<?> arg1,
		    CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(
			root.get(AvailableMarketSurveys_.id).get(AvailableMarketSurveysId_.marketSurveyInformation),
			urn);
	    }
	};
    }

    public static Specification<AvailableMarketSurveys> withAviableUrn(final String urn) {
	return new Specification<AvailableMarketSurveys>() {

	    @Override
	    public Predicate toPredicate(Root<AvailableMarketSurveys> root, CriteriaQuery<?> arg1,
		    CriteriaBuilder criteriaBuilder) {
		Join<AvailableMarketSurveys, AvailableMarketSurveysId> id = root.join(AvailableMarketSurveys_.id);
		id.fetch(AvailableMarketSurveysId_.marketSurveyInformation);
		return criteriaBuilder.equal(id.get(AvailableMarketSurveysId_.availableMarketUrn), urn);
	    }
	};
    }
}
