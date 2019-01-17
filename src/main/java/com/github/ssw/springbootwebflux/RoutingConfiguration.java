package com.github.ssw.springbootwebflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfiguration {

    /*@Autowired
    MyHandler myHandler;

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        return route(GET("/book").and(accept(APPLICATION_JSON)), myHandler::getBooks)
                .andNest(path("/data"), route(GET("/jsondata").and(accept(APPLICATION_JSON)), myHandler::getJson)
                        .andRoute(GET("/xmlTest").and(accept(APPLICATION_JSON)), myHandler::getXml)
                );
    }*/

    @Bean
    public RouterFunction<?> routes(MyHandler myHandler) {
        return route(GET("/book").and(accept(APPLICATION_JSON)), myHandler::getBooks)
                .andNest(path("/data"),
                        route(GET("/json").and(accept(APPLICATION_JSON)), myHandler::getJson)
                                .andRoute(GET("/xml").and(accept(APPLICATION_XML)), myHandler::getXml)

                );
    }
}
