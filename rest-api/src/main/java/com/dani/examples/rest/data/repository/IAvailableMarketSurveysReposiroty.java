package com.dani.examples.rest.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.dani.examples.rest.domain.AvailableMarketSurveys;
import com.dani.examples.rest.domain.AvailableMarketSurveysId;

public interface IAvailableMarketSurveysReposiroty extends JpaRepository<AvailableMarketSurveys, AvailableMarketSurveysId>,
	JpaSpecificationExecutor<AvailableMarketSurveys> {

}
