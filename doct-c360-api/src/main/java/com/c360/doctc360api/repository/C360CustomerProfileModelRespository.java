package com.c360.doctc360api.repository;


import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface C360CustomerProfileModelRespository extends ReactiveMongoRepository<CustomerProfileResponse,String> {

    Mono<CustomerProfileResponse> findById(String id);
}