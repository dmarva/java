package integration.com.dani.examples.rest.utils.specbuilder;

import static org.hamcrest.Matchers.is;

import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;

public class AviableMarketSurveySpecBuilder {

    private final ResponseSpecBuilder responseSpecBuilder;

    public AviableMarketSurveySpecBuilder() {
	responseSpecBuilder = new ResponseSpecBuilder();
    }

    public static AviableMarketSurveySpecBuilder aBuilder() {
	return new AviableMarketSurveySpecBuilder();
    }

    public ResponseSpecification build() {
	return responseSpecBuilder.build();
    }

    private AviableMarketSurveySpecBuilder expect(final String aviableMarketUrn) {
	responseSpecBuilder.expectBody("urn", is(aviableMarketUrn));
	return this;
    }

    public static ResponseSpecification expectUrn(final String aviableMarketUrn) {
	return AviableMarketSurveySpecBuilder.aBuilder().expect(aviableMarketUrn).build();
    }
}
