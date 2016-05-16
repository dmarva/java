package com.dani.examples.rest.service.exception;

import java.util.NoSuchElementException;

public class MarketSurveysMessageNotFoundServiceException extends NoSuchElementException {

    private static final long serialVersionUID = 1087979746075251064L;

    public MarketSurveysMessageNotFoundServiceException(String message) {
	super(message);
    }
}
