package com.dani.examples.rest.api.controller.dto.response.mapper;

import org.springframework.stereotype.Component;

import com.dani.examples.rest.api.controller.dto.response.AviableMarketSurveyResponse;
import com.dani.examples.rest.common.orika.BaseCustomMapper;
import com.dani.examples.rest.domain.AvailableMarketSurveys;

@Component
public class AvailableMarketSurveysToAviableMarketSurveyResponseMapper
	extends BaseCustomMapper<AvailableMarketSurveys, AviableMarketSurveyResponse> {

    public AvailableMarketSurveysToAviableMarketSurveyResponseMapper() {
	super();

	addField("id.availableMarketUrn", "urn");
    }
}
