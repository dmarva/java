package integration.com.dani.examples.rest.utils.specbuilder;

import static org.hamcrest.Matchers.is;

import com.dani.examples.rest.domain.MarketSurveyInformation;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;

public class MarketSurveyInfotmationSpecBuilder {

    private final ResponseSpecBuilder responseSpecBuilder;

    public MarketSurveyInfotmationSpecBuilder() {
	responseSpecBuilder = new ResponseSpecBuilder();
    }

    public static MarketSurveyInfotmationSpecBuilder aBuilder() {
	return new MarketSurveyInfotmationSpecBuilder();
    }

    public ResponseSpecification build() {
	return responseSpecBuilder.build();
    }

    private MarketSurveyInfotmationSpecBuilder expect(final MarketSurveyInformation marketSurveyInformation) {
	responseSpecBuilder.expectBody("marketSurveyUrn", is(marketSurveyInformation.getMarketSurveyUrn()));
	responseSpecBuilder.expectBody("information", is(marketSurveyInformation.getInformation()));
	return this;
    }

    public static ResponseSpecification expectMarketSurvey(final MarketSurveyInformation marketSurveyInformation) {
	return MarketSurveyInfotmationSpecBuilder.aBuilder().expect(marketSurveyInformation).build();
    }
}
