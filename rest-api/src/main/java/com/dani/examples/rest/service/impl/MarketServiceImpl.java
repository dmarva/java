package com.dani.examples.rest.service.impl;

import static com.dani.examples.rest.data.specifications.AvailableMarketSurveysSpecifications.withAviableUrn;
import static com.dani.examples.rest.data.specifications.AvailableMarketSurveysSpecifications.withMarketSurveyInformationUrn;
import static com.dani.examples.rest.data.specifications.MarketSurveyInformationSpecification.withUrn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dani.examples.rest.data.repository.IAvailableMarketSurveysReposiroty;
import com.dani.examples.rest.data.repository.IMarketSurveyInformationReposiroty;
import com.dani.examples.rest.domain.AvailableMarketSurveys;
import com.dani.examples.rest.domain.MarketSurveyInformation;
import com.dani.examples.rest.service.IMarketService;
import com.dani.examples.rest.service.exception.MarketSurveysMessageNotFoundServiceException;

@Service
public class MarketServiceImpl implements IMarketService {

    @Autowired
    private IMarketSurveyInformationReposiroty marketSurveyInformationRepository;
    @Autowired
    private IAvailableMarketSurveysReposiroty availableMarketSurveyRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public AvailableMarketSurveys getAvailableMarketSurvey(String marketSurveyInformationUrn) {
	MarketSurveyInformation marketSurveyInformation = marketSurveyInformationRepository
		.findOne(withUrn(marketSurveyInformationUrn));

	return availableMarketSurveyRepository.findOne(withMarketSurveyInformationUrn(marketSurveyInformation));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = true)
    public MarketSurveyInformation getMarketSurveyInformation(String availableMarketSurveyUrn)
	    throws MarketSurveysMessageNotFoundServiceException {

	AvailableMarketSurveys aviableMarketSurveyInformation = availableMarketSurveyRepository
		.findOne(withAviableUrn(availableMarketSurveyUrn));
	if (aviableMarketSurveyInformation == null) {
	    throw new MarketSurveysMessageNotFoundServiceException(
		    "The aviable market survey " + availableMarketSurveyUrn + " urn not found");
	}
	return aviableMarketSurveyInformation.getId().getMarketSurveyInformation();
    }

}
