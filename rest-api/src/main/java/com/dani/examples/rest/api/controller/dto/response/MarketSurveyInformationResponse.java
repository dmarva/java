package com.dani.examples.rest.api.controller.dto.response;

import java.io.Serializable;

import com.dani.examples.rest.api.dto.AbstractDto;

public class MarketSurveyInformationResponse extends AbstractDto implements Serializable {

    private static final long serialVersionUID = -374615626199236538L;

    private String marketSurveyUrn;

    private String information;

    public String getMarketSurveyUrn() {
	return marketSurveyUrn;
    }

    public void setMarketSurveyUrn(String marketSurveyUrn) {
	this.marketSurveyUrn = marketSurveyUrn;
    }

    public String getInformation() {
	return information;
    }

    public void setInformation(String information) {
	this.information = information;
    }

}
