package com.github.ssw.springbootwebflux;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyHandler {

    public Mono<ServerResponse>  getBooks(ServerRequest request){
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Book book = new Book("spring boot webflux"+i, "000" + i);
            bookList.add(book);
        }
        //Mono<Book> bookMono = Mono.just(book);
        Flux<List<Book>> bookFlux = Flux.just(bookList);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(bookFlux, new ParameterizedTypeReference<List<Book>>(){});
    }
}
