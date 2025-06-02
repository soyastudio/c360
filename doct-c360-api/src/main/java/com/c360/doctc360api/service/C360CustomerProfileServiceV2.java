// src/main/java/com/c360/doctc360api/service/C360CustomerProfileService.java
package com.c360.doctc360api.service;

import com.c360.doctc360api.configuration.ApplicationProperties;
import com.c360.doctc360api.dao.UserProfileAccessLayerV2;
import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class C360CustomerProfileServiceV2 {

    private ApplicationProperties applicationProperties;
    private UserProfileAccessLayerV2 userProfileAccessLayer;
    private final Counter counter = Metrics.counter("requests_total");
    private final Timer timer = Metrics.timer("requests_duration");

    ReactiveRedisOperations<String, CustomerProfileResponse> redisOperationsForCustomerProfile;

    public C360CustomerProfileServiceV2(@Qualifier("UserProfileDaoImpl") UserProfileAccessLayerV2 userProfileAccessLayer,
                                        @Autowired(required = false) ReactiveRedisOperations<String, CustomerProfileResponse> redisOperationsForCustomerProfile,
                                        ApplicationProperties applicationProperties) {
        this.userProfileAccessLayer = userProfileAccessLayer;
        this.redisOperationsForCustomerProfile = redisOperationsForCustomerProfile;
        this.applicationProperties = applicationProperties;
    }

    public ResponseEntity<Mono<CustomerProfileResponse>> getProfileData(String customerUUID) {
        String cacheKey = "V2"+customerUUID;
        counter.increment();
        Timer.Sample sample = Timer.start();
        log.info("Redis switch --> : " + applicationProperties.getRedisSwitch() + " ttl: " + applicationProperties.getTtl());

        if ("ON".equalsIgnoreCase(applicationProperties.getRedisSwitch())) {
            ReactiveValueOperations<String, CustomerProfileResponse> valueOps = redisOperationsForCustomerProfile.opsForValue();
            Mono<CustomerProfileResponse> cachedMono = valueOps.get(cacheKey)
                    .switchIfEmpty(Mono.defer(() -> fetchProfileFromMongo(customerUUID)
                            .flatMap(it -> valueOps.set(cacheKey, it, Duration.ofHours(applicationProperties.getTtl()))
                                    .then(Mono.just(it)))));
            sample.stop(timer);
            return ResponseEntity.ok(cachedMono);
        } else {
            return ResponseEntity.ok(fetchProfileFromMongo(customerUUID));
        }
    }

    private Mono<CustomerProfileResponse> fetchProfileFromMongo(String customerUUID) {
        log.info("Fetching data from mongodb for UUId:{}", customerUUID);
        return userProfileAccessLayer.getCustomerDetails(customerUUID);
    }
}