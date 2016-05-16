package com.dani.examples.rest.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.dani.examples.rest.common.orika", "com.dani.examples.rest.api.controller.dto.response.mapper" })
public class OrikaConfiguration {

}