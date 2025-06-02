package com.c360.doctc360api.repository;

import com.c360.doctc360api.model.v3.CustomerProfileResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface C360CustomerInfoV3Repository extends ReactiveMongoRepository<CustomerProfileResponse,String> {

    Mono<CustomerProfileResponse> findById(String id);
}
