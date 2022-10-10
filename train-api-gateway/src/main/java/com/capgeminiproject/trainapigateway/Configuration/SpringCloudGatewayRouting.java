package com.capgeminiproject.trainapigateway.Configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@CrossOrigin("*")
@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder)
    {
        return (RouteLocator) builder.routes()
                .route("TRAIN-MANAGEMENT-SERVICE",r-> r.path("/trains/**").uri("lb://TRAIN-MANAGEMENT-SERVICE"))
                .route("ADMIN-MANAGEMENT-SERVICE",r->r.path("/admin/**").uri("lb://ADMIN-MANAGEMENT-SERVICE"))
                .route("PASSENGER-MANAGEMENT-SERVICE",r->r.path("/passenger/**").uri("lb://PASSENGER-MANAGEMENT-SERVICE"))
                .route("BOOKING-MANAGEMENT-SERVICE",r->r.path("/booking/**").uri("lb://BOOKING-MANAGEMENT-SERVICE"))
                .build();
    }

}