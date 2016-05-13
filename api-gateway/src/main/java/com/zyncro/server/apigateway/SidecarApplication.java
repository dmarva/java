package com.zyncro.server.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.context.ContextLifecycleFilter;

@SpringBootApplication
@EnableSidecar
public class SidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }

    @Bean
    public ContextLifecycleFilter contextLifecycleFilter() {
        return new ContextLifecycleFilter();
    }
}
