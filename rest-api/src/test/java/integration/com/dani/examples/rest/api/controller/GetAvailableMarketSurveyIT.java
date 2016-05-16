package integration.com.dani.examples.rest.api.controller;

import static com.jayway.restassured.RestAssured.given;
import static integration.com.dani.examples.rest.utils.specbuilder.AviableMarketSurveySpecBuilder.expectUrn;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import integration.com.dani.examples.rest.annotations.ApiIntegrationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ApiIntegrationTest
public class GetAvailableMarketSurveyIT {

    private static final String MARKET_INFORMATION_SURVEY_URN = "survey_information:E21953EC-1AB2-11E6-8FE2-FEC54A0D5663";
    private static final String EXPECTED_AVIABLE_MARKET_SURVEY = "available_survey:6CB4B636-1AB3-11E6-8282-80C64A0D5663";

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
	RestAssured.port = port;
    }

    @Test
    public void test_available_market_survey_not_found() throws Exception {

	// @formatter:off
        given().
            pathParam("marketSurveyInformationUrn", "this_will_not_work").
        when().
            get("/api/available-market-survey/{marketSurveyInformationUrn}").
        then().log().all().
            assertThat().
                statusCode(HttpStatus.NOT_FOUND.value()).
            and().
            	body("message", equalTo("The market survey is not aviable"));
        // @formatter:on
    }

    @Test
    public void test_available_market_survey_found() throws Exception {

	// @formatter:off
        given().
            pathParam("marketSurveyInformationUrn", MARKET_INFORMATION_SURVEY_URN).
        when().
            get("/api/available-market-survey/{marketSurveyInformationUrn}").
        then().log().all().
            assertThat().
                statusCode(HttpStatus.OK.value()).
            and().
                contentType(ContentType.JSON).
            and().
                spec(expectUrn(EXPECTED_AVIABLE_MARKET_SURVEY));
        // @formatter:on
    }
}
