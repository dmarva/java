package com.dani.examples.rest.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class AvailableMarketSurveys implements Serializable {

    private static final long serialVersionUID = 6578955017952956122L;

    @EmbeddedId
    private AvailableMarketSurveysId id;

    public AvailableMarketSurveys() {
	super();
    }

    public AvailableMarketSurveys(String aviableMarketUrn, MarketSurveyInformation marketSurveyInformation) {
	super();
	this.id.setAvailableMarketUrn(aviableMarketUrn);
	this.id.setMarketSurveyInformation(marketSurveyInformation);
    }

    public AvailableMarketSurveysId getId() {
	return id;
    }

    public void setId(AvailableMarketSurveysId id) {
	this.id = id;
    }

}
