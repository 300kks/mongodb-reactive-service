package com.vmokrecov.worldservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WorldController {

    @GetMapping("world")
    public Mono<String> world() {
        return Mono.just("{ \"message\": \"world\" }");
    }
}
