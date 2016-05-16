package com.dani.examples.rest.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MarketSurveyInformation.class)
public class MarketSurveyInformation_ {

    public static volatile SingularAttribute<MarketSurveyInformation, Long> id;
    public static volatile SingularAttribute<MarketSurveyInformation, String> marketSurveyUrn;
    public static volatile SingularAttribute<MarketSurveyInformation, String> information;

}
