package integration.com.dani.examples.rest.api.controller;

import static com.jayway.restassured.RestAssured.given;
import static integration.com.dani.examples.rest.utils.objectmother.MarketSurveyInfoObjectMother.getFirstMarketSurveyInformation;
import static integration.com.dani.examples.rest.utils.specbuilder.MarketSurveyInfotmationSpecBuilder.expectMarketSurvey;
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
public class GetMarketSurveyInformationIT {

    private static final String AVIABLE_MARKET_SURVEY_URN = "available_survey:6CB4B636-1AB3-11E6-8282-80C64A0D5663";

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
	RestAssured.port = port;
    }

    @Test
    public void test_market_survey_information_not_found() throws Exception {

	// @formatter:off
        given().
            pathParam("availableMarketUrn", "this_will_not_work").
        when().
            get("/api/market-survey-information/{availableMarketUrn}").
        then().
            assertThat().
                statusCode(HttpStatus.NOT_FOUND.value()).
            and().
            	body("message", equalTo("The aviable market survey this_will_not_work urn not found"));
        // @formatter:on
    }

    @Test
    public void test_market_survey_information_found() throws Exception {

	// @formatter:off
        given().
            pathParam("availableMarketUrn", AVIABLE_MARKET_SURVEY_URN).
        when().
            get("/api/market-survey-information/{availableMarketUrn}").
        then().
            assertThat().
                statusCode(HttpStatus.OK.value()).
            and().
                contentType(ContentType.JSON).
            and().
                spec(expectMarketSurvey(getFirstMarketSurveyInformation()));
        // @formatter:on
    }

}
