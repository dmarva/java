package com.dani.examples.rest.api.util;

public class ApiConstants {

    public static final String API = "/api";

    public static final String MARKET_SURVEY = "/market-survey";
    public static final String AVIABLE_MARKET_SURVEY = "/available-market-survey";
    public static final String MARKET_SURVEY_INFORMATION = "/market-survey-information";

    public static final String AVIABLE_MARKET_SURVEY_PATH = "/{availableMarketUrn}";
    public static final String MARKET_SURVEY_INFORMATION_PATH = "/{marketSurveyInformationUrn}";

    public static final String BASE_MARKET_SURVEY = API + MARKET_SURVEY;
    public static final String BASE_AVIABLE_MARKET_SURVEY = API + AVIABLE_MARKET_SURVEY;
    public static final String BASE_MARKET_SURVEY_INFORMATION = API + MARKET_SURVEY_INFORMATION;
}
