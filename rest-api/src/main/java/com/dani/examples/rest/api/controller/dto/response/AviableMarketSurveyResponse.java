package com.dani.examples.rest.api.controller.dto.response;

import java.io.Serializable;

import com.dani.examples.rest.api.dto.AbstractDto;

public class AviableMarketSurveyResponse extends AbstractDto implements Serializable {

    private static final long serialVersionUID = 3191133266571108781L;

    private String urn;

    public String getUrn() {
	return urn;
    }

    public void setUrn(String urn) {
	this.urn = urn;
    }

}
