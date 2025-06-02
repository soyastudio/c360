package com.c360.doctc360api.service.bnc;

import com.c360.doctc360api.configuration.ApplicationProperties;
import com.c360.doctc360api.dao.bnc.BncTransactionDao;
import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
@Service
@Slf4j
public class BncCustTransService {

        private ApplicationProperties applicationProperties;
        private BncTransactionDao bncTransactionDao;
        private final Counter counter = Metrics.counter("requests_total");
        private final Timer timer = Metrics.timer("requests_duration");

        ReactiveRedisOperations<String, BncTransactionDataModel> redisOperationsForFulfillmentApi;

    public BncCustTransService(BncTransactionDao bncTransactionDao,
                               @Autowired(required = false) ReactiveRedisOperations<String, BncTransactionDataModel> redisOperationsForFulfillmentApi,
                               ApplicationProperties applicationProperties) {
        this.bncTransactionDao = bncTransactionDao;
        this.redisOperationsForFulfillmentApi = redisOperationsForFulfillmentApi;
        this.applicationProperties = applicationProperties;
    }

        public ResponseEntity<Mono<BncTransactionDataModel>> getBncTransactionData(String customerUUID) {
        String cacheKey = "bnc"+customerUUID;
        counter.increment();
        Timer.Sample sample = Timer.start();
        log.info("Redis switch --> : " + applicationProperties.getRedisSwitch() + " ttl: " + applicationProperties.getTtl());

        if ("ON".equalsIgnoreCase(applicationProperties.getRedisSwitch())) {
            ReactiveValueOperations<String, BncTransactionDataModel> valueOps = redisOperationsForFulfillmentApi.opsForValue();
            Mono<BncTransactionDataModel> cachedMono = valueOps.get(cacheKey)
                    .switchIfEmpty(Mono.defer(() -> fetchBncTransactionDataFromMongo(customerUUID)
                            .flatMap(it -> valueOps.set(cacheKey, it, Duration.ofHours(applicationProperties.getTtl()))
                                    .then(Mono.just(it)))));
            sample.stop(timer);
            return ResponseEntity.ok(cachedMono);
        } else {
            return ResponseEntity.ok(fetchBncTransactionDataFromMongo(customerUUID));
        }
    }

        private Mono<BncTransactionDataModel> fetchBncTransactionDataFromMongo(String customerUUID) {
        log.info("Fetching data from mongodb for UUId:{}", customerUUID);
        return bncTransactionDao.getTransactionData(customerUUID);
    }

    }

