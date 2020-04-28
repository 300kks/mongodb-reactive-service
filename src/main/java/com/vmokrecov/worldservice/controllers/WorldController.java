package com.vmokrecov.worldservice.controllers;

import com.vmokrecov.worldservice.dto.MessagesDTO;
import com.vmokrecov.worldservice.services.MessagesService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Api(tags = "WorldController admin", description = "WorldController description")
public class WorldController {

    private final MessagesService serivce;

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

    @GetMapping("/world/message/{id}")
    public Mono<MessagesDTO> getMessageById(@PathVariable Long id) {
        return serivce.getMessage(id);
    }

    @GetMapping("/world/messages")
    public Flux<MessagesDTO> getAllMessages() {
        return serivce.getAllMessages();
    }
}
