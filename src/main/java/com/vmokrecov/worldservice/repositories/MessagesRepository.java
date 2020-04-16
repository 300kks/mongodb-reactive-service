package com.vmokrecov.worldservice.repositories;

import com.vmokrecov.worldservice.domain.Messages;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends ReactiveMongoRepository<Messages, Long> {

}
