package br.com.aldeir.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	public RouteLocator gatewayRouter( RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> funtion=
				p -> p.path("/get")
				.filters(f -> f.addRequestHeader("hello", "world")
				               .addRequestParameter("hello", "world"))
				.uri("http://httpbin.org:80");
		return builder.routes().
				route(funtion).build();
	}

}
