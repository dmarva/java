package com.dani.examples.rest.service;

import com.dani.examples.rest.domain.AvailableMarketSurveys;
import com.dani.examples.rest.domain.MarketSurveyInformation;
import com.dani.examples.rest.service.exception.MarketSurveysMessageNotFoundServiceException;

public interface IMarketService {

    AvailableMarketSurveys getAvailableMarketSurvey(String marketSurveyInformationUrn);

    MarketSurveyInformation getMarketSurveyInformation(String aviableMarketSurveyUrn)
	    throws MarketSurveysMessageNotFoundServiceException;

}
