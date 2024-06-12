package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("binarfud", r -> r.path("/binarfud/**")
                        .uri("http://localhost:8080/")

                )
                .route("consumer", r -> r.path("/consumer/**")
                        .uri("http://localhost:8081")
                )
                .build();

    }
}
