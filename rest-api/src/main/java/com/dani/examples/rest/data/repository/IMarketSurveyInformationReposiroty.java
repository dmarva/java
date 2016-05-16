package com.dani.examples.rest.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.dani.examples.rest.domain.MarketSurveyInformation;

public interface IMarketSurveyInformationReposiroty
	extends JpaRepository<MarketSurveyInformation, Long>, JpaSpecificationExecutor<MarketSurveyInformation> {

}
