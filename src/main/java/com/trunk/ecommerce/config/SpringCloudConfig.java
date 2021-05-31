package com.trunk.ecommerce.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/user/**")
                        .uri("http://localhost:9092/"))
                .route(r -> r.path("/product/**")
                        .uri("http://localhost:9093/"))
                .route(r -> r.path("/cart/**")
                        .uri("http://localhost:9091/"))
                .build();
    }
}
