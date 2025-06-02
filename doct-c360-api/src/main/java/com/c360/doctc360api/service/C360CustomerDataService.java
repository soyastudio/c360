package com.c360.doctc360api.service;

import com.c360.doctc360api.configuration.ApplicationProperties;
import com.c360.doctc360api.dao.UserDataAccessLayer;
import com.c360.doctc360api.model.C360CustomerDataModel;
import com.c360.doctc360api.model.DailyTransactions;
import com.c360.doctc360api.model.DailyTransactionsResponse;
import com.c360.doctc360api.model.TransactionsResponse;
import com.c360.doctc360api.repository.C360DailyTransactionsRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class C360CustomerDataService {

    private ApplicationProperties applicationProperties;
    private UserDataAccessLayer userDataAccessLayer;
    private final Counter counter = Metrics.counter("requests_total");
    private final Timer timer = Metrics.timer("requests_duration");

    private C360DailyTransactionsRepository dailyTransactionsRepository;

    ReactiveRedisOperations<String, C360CustomerDataModel> redisOperationsForMealPreferences;

    public C360CustomerDataService(@Qualifier("UserDataDaoImpl") UserDataAccessLayer userDataAccessLayer,
                                   @Autowired(required = false) ReactiveRedisOperations<String, C360CustomerDataModel> redisOperationsForMealPreferences,
                                   C360DailyTransactionsRepository dailyTransactionsRepository,
                                   ApplicationProperties applicationProperties) {
        this.redisOperationsForMealPreferences = redisOperationsForMealPreferences;
        this.userDataAccessLayer = userDataAccessLayer;
        this.dailyTransactionsRepository = dailyTransactionsRepository;
        this.applicationProperties = applicationProperties;
    }

    private Mono<C360CustomerDataModel> fetchValueFromMongo(String customerUUID){
            log.info("Fetching data from mongodb for UUId:{}",customerUUID);
            return userDataAccessLayer.getMealPreferencesDetails(customerUUID);
    }

    public ResponseEntity<Mono<C360CustomerDataModel>> getCustomerData(String customerUUID) {
        String cacheKey =  "V1"+customerUUID;
        counter.increment();
        Timer.Sample sample = Timer.start();
        log.info("Redis switch --> : " + applicationProperties.getRedisSwitch()
                +"ttl: "+applicationProperties.getTtl());
        if ("ON".equalsIgnoreCase(applicationProperties.getRedisSwitch())) {
         //   log.info("Redis Performance test timer --> : " + new Date());
                ReactiveValueOperations<String, C360CustomerDataModel> valueOps = redisOperationsForMealPreferences.opsForValue();
                Mono<C360CustomerDataModel> cachedMono = valueOps.get(cacheKey)
                        .switchIfEmpty(Mono.defer(() -> fetchValueFromMongo(customerUUID).
                                flatMap(it -> {
                                    return valueOps.set(cacheKey, it,
                                           // Duration.ofMinutes(applicationProperties.getTtl())).then(Mono.just(it));
                                            Duration.ofHours(applicationProperties.getTtl())).then(Mono.just(it));
                                })));
                sample.stop(timer);
                return ResponseEntity.ok(cachedMono);
            }else{
                return ResponseEntity.ok(fetchValueFromMongo(customerUUID));
            }
        }

    public Mono<TransactionsResponse> getDailyTransactionByUuidAndDate(String uuid, Date startDate, Date endDate) {
        TransactionsResponse transactionsResponse = new TransactionsResponse();
        transactionsResponse.setUuid(uuid);
        Flux<DailyTransactions> dailyTransactionsFlux;
        if(startDate != null && endDate != null) {
            dailyTransactionsFlux = dailyTransactionsRepository.findByUuidAndTransactionDateBetween(uuid, startDate, endDate);
        } else {
            dailyTransactionsFlux = dailyTransactionsRepository.findByUuid(uuid);
        }
        List<DailyTransactionsResponse> dailyTransactionsResponses = new ArrayList<>();
                dailyTransactionsFlux.doOnNext(data -> dailyTransactionsResponses.add(toDailyTransactionsResponse(data))).collectList().block();
        transactionsResponse.setTransactions(dailyTransactionsResponses);
        return Mono.just(transactionsResponse);
    }

    private DailyTransactionsResponse toDailyTransactionsResponse(DailyTransactions dailyTransaction) {
        DailyTransactionsResponse dailyTransactionsResponse = new DailyTransactionsResponse();
        BeanUtils.copyProperties(dailyTransaction,dailyTransactionsResponse);
        return dailyTransactionsResponse;
    }
}