package com.vmokrecov.worldservice.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WorldController {

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("{ \"message\": \"Home\" }");
    }

    @GetMapping("/world")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Mono<String> getWorld() {
        return Mono.just("{ \"message\": \"World\" }");
    }

    @PostMapping("/world")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Mono<String> postWorld() {
        return Mono.just("{ \"message\": \"World Post\" }");
    }
}
