package com.dani.examples.rest.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {

	super.configure(http);

	http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/api/**").permitAll();

    }

}