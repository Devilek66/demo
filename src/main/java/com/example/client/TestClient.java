package com.example.client;


import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

@Client("http://metaphorpsum.com")
public interface TestClient {
    @Get(uri = "/paragraphs/2")
    @Consumes
    Mono<String> data();
}
