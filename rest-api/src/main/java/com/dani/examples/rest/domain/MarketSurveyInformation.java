package com.dani.examples.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MarketSurveyInformation implements Serializable {

    private static final long serialVersionUID = -4448291382240936225L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "market_survey_urn", unique = true, nullable = false)
    private String marketSurveyUrn;

    @Column(name = "information", nullable = false)
    private String information;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

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

    public static class Builder {
	private MarketSurveyInformation marketSurveyInformation;

	public Builder() {
	    marketSurveyInformation = new MarketSurveyInformation();
	}

	public Builder id(Long value) {
	    marketSurveyInformation.setId(value);
	    return this;
	}

	public Builder marketSurveyUrn(String value) {
	    marketSurveyInformation.setMarketSurveyUrn(value);
	    return this;
	}

	public Builder information(String value) {
	    marketSurveyInformation.setInformation(value);
	    return this;
	}

	public MarketSurveyInformation build() {
	    return marketSurveyInformation;
	}
    }
}
