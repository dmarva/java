package com.dani.examples.rest.api.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dani.examples.rest.api.controller.dto.response.AviableMarketSurveyResponse;
import com.dani.examples.rest.api.controller.dto.response.MarketSurveyInformationResponse;
import com.dani.examples.rest.api.exception.AvailableMarketSurveysNotFoundApiException;
import com.dani.examples.rest.api.exception.MarketSurveysInformationNotFoundApiException;
import com.dani.examples.rest.api.util.ApiConstants;
import com.dani.examples.rest.common.orika.OrikaBeanMapper;
import com.dani.examples.rest.domain.AvailableMarketSurveys;
import com.dani.examples.rest.domain.MarketSurveyInformation;
import com.dani.examples.rest.service.IMarketService;
import com.dani.examples.rest.service.exception.MarketSurveysMessageNotFoundServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = { ApiConstants.BASE_MARKET_SURVEY }, value = "Market survey operations")
public class MarketSurveyController {

    @Autowired
    private OrikaBeanMapper mapper;

    @Autowired
    private IMarketService marketService;

    @RequestMapping(value = ApiConstants.BASE_MARKET_SURVEY_INFORMATION
	    + ApiConstants.AVIABLE_MARKET_SURVEY_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = {
	    ApiConstants.BASE_MARKET_SURVEY }, value = "Get task by urn provided", produces = MediaType.APPLICATION_JSON_VALUE, response = MarketSurveyInformationResponse.class)
    public @ResponseBody MarketSurveyInformationResponse getMarketSurveyInformation(
	    @ApiParam(name = "availableMarketUrn", value = "Available market surveys message urn to grant access", required = true) @NotNull @PathVariable("availableMarketUrn") final String availableMarketUrn)
	    throws Exception {
	MarketSurveyInformation marketSurveyInformation;
	try {
	    marketSurveyInformation = marketService.getMarketSurveyInformation(availableMarketUrn);
	} catch (MarketSurveysMessageNotFoundServiceException e) {
	    throw new MarketSurveysInformationNotFoundApiException(e);
	}
	return mapper.map(marketSurveyInformation, MarketSurveyInformationResponse.class);
    }

    @RequestMapping(value = ApiConstants.BASE_AVIABLE_MARKET_SURVEY
	    + ApiConstants.MARKET_SURVEY_INFORMATION_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(tags = {
	    ApiConstants.BASE_MARKET_SURVEY }, value = "Get available market survey by market survey information", produces = MediaType.APPLICATION_JSON_VALUE, response = AviableMarketSurveyResponse.class)
    public @ResponseBody AviableMarketSurveyResponse getAviableMarketSurvey(
	    @ApiParam(name = "marketSurveyInformationUrn", value = "Market survey information urn to grant access", required = true) @NotNull @PathVariable("marketSurveyInformationUrn") final String marketSurveyInformationUrn)
	    throws Exception {
	AvailableMarketSurveys availableMarketSurveys = marketService
		.getAvailableMarketSurvey(marketSurveyInformationUrn);
	if (availableMarketSurveys == null) {
	    throw new AvailableMarketSurveysNotFoundApiException("The market survey is not aviable");
	}
	return mapper.map(availableMarketSurveys, AviableMarketSurveyResponse.class);
    }
}
