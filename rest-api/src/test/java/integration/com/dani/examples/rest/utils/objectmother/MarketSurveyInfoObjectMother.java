package integration.com.dani.examples.rest.utils.objectmother;

import com.dani.examples.rest.domain.MarketSurveyInformation;

public class MarketSurveyInfoObjectMother {

    public static MarketSurveyInformation getFirstMarketSurveyInformation() {
	return new MarketSurveyInformation.Builder().id(1L)
		.marketSurveyUrn("survey_information:E21953EC-1AB2-11E6-8FE2-FEC54A0D5663")
		.information("Lorem ipsum dolor sit amet, consectetur adipiscing elit.").build();
    }
}
