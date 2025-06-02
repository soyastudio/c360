package com.c360.doctc360api.repository;

import com.c360.doctc360api.model.C360CustomerDataModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface C360CustomerInfoModelRepository extends ReactiveMongoRepository<C360CustomerDataModel,String> {

  //  Mono<C360MealPreferencesModel> findByUuid(String uuid);
    Mono<C360CustomerDataModel> findById(String id);

}
