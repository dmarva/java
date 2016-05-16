package com.dani.examples.rest.api.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AvailableMarketSurveysNotFoundApiException extends NoSuchElementException {

    private static final long serialVersionUID = 8408940873518102499L;

    public AvailableMarketSurveysNotFoundApiException(String msg) {
	super(msg);
    }

}
