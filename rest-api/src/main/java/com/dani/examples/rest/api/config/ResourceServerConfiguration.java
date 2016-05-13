package com.dani.examples.rest.api.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String OAUTH_CHECK_TOKEN_ENDPOINT = "http://authorization-service/oauth/check_token";

	private static final String APPLICATION_CLIENT_SECRET_PROPERTY_KEY = "application.clientSecret";

	private static final String APPLICATION_CLIENT_ID_PROPERTY_KEY = "application.clientId";

	@Resource(name = "excludePathsForGZIP")
	private List<String> excludePathsForGZIP;

	@Autowired
	Environment environment;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		// @formatter:off
		super.configure(http);

		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/docs/**", "/v2/api-docs/**", "/api-docs/**", "/api/version/**").permitAll()
				.antMatchers("/api/**").access("#oauth2.hasAnyScopeMatching('trust')").antMatchers("/remoting/**")
				.permitAll();

		http.headers().xssProtection();
		http.headers().frameOptions();

		// @formatter:on
	}

	@Bean
	public BaseAccessDeniedHandler accessDeniedHandler() {
		return new BaseAccessDeniedHandler();
	}

	@Bean
	public BaseAuthenticationEntryPoint authenticationEntryPoint() {
		return new BaseAuthenticationEntryPoint();
	}

	@Bean
	public ResourceServerTokenServices tokenService() {
		RemoteTokenServices remoteTokenServices = new BalancedRemoteTokenServices();
		remoteTokenServices.setClientId(environment.getRequiredProperty(APPLICATION_CLIENT_ID_PROPERTY_KEY));
		remoteTokenServices.setClientSecret(environment.getRequiredProperty(APPLICATION_CLIENT_SECRET_PROPERTY_KEY));
		remoteTokenServices.setCheckTokenEndpointUrl(OAUTH_CHECK_TOKEN_ENDPOINT);
		return remoteTokenServices;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.authenticationManager(authenticationManagerBean());
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
		authenticationManager.setTokenServices(tokenService());
		return authenticationManager;
	}

	@Bean
	public List<String> excludePathsForGZIP() {
		return Arrays.asList();
	}

}