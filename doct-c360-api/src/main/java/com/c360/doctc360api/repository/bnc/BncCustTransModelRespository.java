package com.c360.doctc360api.repository.bnc;


import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface BncCustTransModelRespository extends ReactiveMongoRepository<BncTransactionDataModel,String> {

    Mono<BncTransactionDataModel> findById(String id);
}