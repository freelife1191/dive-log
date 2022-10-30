package com.freelife.divelog.web.diveresort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class DiveResortRoutingConfiguration {
    private static final RequestPredicate ACCEPT_JSON = accept(MediaType.APPLICATION_JSON);
    
    @Bean
    public RouterFunction<ServerResponse> routerFunction(DiveResortHandler diveResortHandler) {
        return RouterFunctions.route()
                .GET("/v2/dive-resorts", ACCEPT_JSON, diveResortHandler::findAll)
                .build();
    }
}
