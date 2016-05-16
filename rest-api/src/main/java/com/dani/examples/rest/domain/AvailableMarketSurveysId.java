package com.dani.examples.rest.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@Access(AccessType.FIELD)
public class AvailableMarketSurveysId implements Serializable {

    private static final long serialVersionUID = 6652543070512404578L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_survey_information_id", nullable = false)
    private MarketSurveyInformation marketSurveyInformation;

    @Column(name = "available_market_urn", unique = true, nullable = false)
    private String availableMarketUrn;

    public MarketSurveyInformation getMarketSurveyInformation() {
	return marketSurveyInformation;
    }

    public void setMarketSurveyInformation(MarketSurveyInformation marketSurveyInformation) {
	this.marketSurveyInformation = marketSurveyInformation;
    }

    public String getAvailableMarketUrn() {
	return availableMarketUrn;
    }

    public void setAvailableMarketUrn(String availableMarketUrn) {
	this.availableMarketUrn = availableMarketUrn;
    }

}
