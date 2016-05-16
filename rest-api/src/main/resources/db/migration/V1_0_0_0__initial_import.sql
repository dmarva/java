CREATE TABLE market_survey_information (
  id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  market_survey_urn VARCHAR(56) NOT NULL,
  information VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT uq_market_survey_urn UNIQUE (market_survey_urn),
  INDEX ix_market_survey_urn (urn ASC);
  
CREATE TABLE available_market_surveys (
  available_market_urn VARCHAR(56) NOT NULL,
  market_survey_information_id BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (available_market_urn, market_survey_information_id),
  INDEX ix_available_market_urn (available_market_urn ASC),
  CONSTRAINT fk_available_market_surveys_information FOREIGN KEY (market_survey_information_id) REFERENCES market_survey_information (id) ON DELETE NO ACTION ON UPDATE NO ACTION);