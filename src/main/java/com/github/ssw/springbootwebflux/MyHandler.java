package com.github.ssw.springbootwebflux;

import com.github.underscore.lodash.U;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MyHandler {

    public Mono<ServerResponse> getBooks(ServerRequest request) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Book book = new Book("spring boot webflux" + i, "000" + i);
            bookList.add(book);
        }
        //Mono<Book> bookMono = Mono.just(book);
        Flux<List<Book>> bookFlux = Flux.just(bookList);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookFlux, new ParameterizedTypeReference<List<Book>>() {
                });
    }

    public Mono<ServerResponse> getJson(ServerRequest request) {
        String xmlString = "<XML_SELECT><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName></XML_SELECT>";
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jsonObject.toString()), String.class);
    }

    public Mono<ServerResponse> getXml(ServerRequest request) {
        String json = "{\"cityCode\":\"DEFHI\",\"countryCode\":\"DE\",\"stateCode\":null,\"cityFileName\":\"Flonheim_DE\",\"cityNameEn\":\"Flonheim\",\"cityNameKo\":\"Flonheim\",\"cityNameJa\":null,\"cityNameZh\":null,\"cityNameFr\":null,\"cityNameEs\":null,\"cityNameDe\":null}";
        String xml = U.jsonToXml(json);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(Mono.just(xml), String.class);
    }

}
