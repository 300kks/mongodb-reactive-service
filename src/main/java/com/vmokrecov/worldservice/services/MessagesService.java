package com.vmokrecov.worldservice.services;

import com.vmokrecov.worldservice.dto.MessagesDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessagesService {

    Mono<MessagesDTO> getMessage(Long id);
    Flux<MessagesDTO> getAllMessages();
}
