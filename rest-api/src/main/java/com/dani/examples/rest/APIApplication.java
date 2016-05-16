package com.dani.examples.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.annotation.Import;

import com.dani.examples.rest.api.config.ApiConfiguration;

@SpringBootApplication(exclude = { SolrAutoConfiguration.class })
@Import({ ApiConfiguration.class })
public class APIApplication {

    public static void main(String[] args) {
	SpringApplication.run(APIApplication.class, args);
    }

}
