package com.dani.examples.rest.api.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.dani.examples.rest.common.OrikaConfiguration;

@Configuration
@Import({ ResourceServerConfiguration.class, OrikaConfiguration.class })
@EnableAspectJAutoProxy
@EnableAsync
@EnableEurekaClient
public class ApiConfiguration extends WebSecurityConfigurerAdapter {

}
