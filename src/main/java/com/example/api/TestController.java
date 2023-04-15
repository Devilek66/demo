package com.example.api;

import com.example.client.TestClient;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


@Controller("/hello")
public class TestController {
    private final TestClient testClient;

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    public TestController(TestClient testClient) {
        this.testClient = testClient;
    }

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public Mono<String> index() {
        log.error("Log before get");
        return testClient.data().map(x -> {
            log.error("log on map");
            return x;
        });
    }
}
