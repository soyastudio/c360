package com.c360.doctc360api.repository;

import com.c360.doctc360api.model.DailyTransactions;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;


@Repository
public interface C360DailyTransactionsRepository extends ReactiveMongoRepository<DailyTransactions,String> {

    Flux<DailyTransactions> findByUuid(String uuid);
    @Query("{'uuid':  ?0, 'transactionDate':  {$gte: ?1, $lte: ?2}}")
    Flux<DailyTransactions> findByUuidAndTransactionDateBetween(String uuid, Date startDate, Date endDate);

}
