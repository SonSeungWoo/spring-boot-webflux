package com.github.ssw.springbootwebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class MyRestController {

    @GetMapping("/user")
    public String getUser() {
        return "SonSeungWoo";
    }

    @GetMapping("flux")
    public Flux<String> getFlux() {
        return Flux.just("a", "b", "c");
    }

    @GetMapping("/mono")
    public Mono<String> getMono() {
        return Mono.just("mono");
    }

}
