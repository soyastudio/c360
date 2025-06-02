package com.c360.doctc360api.service.catalog;

import com.c360.doctc360api.configuration.ApplicationProperties;
import com.c360.doctc360api.dao.bnc.BncTransactionDao;
//import com.c360.doctc360api.dao.catalog.CatalogMetaDataDao;
import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@Service
@Slf4j
public class CatalogMetaDataService {

        private ApplicationProperties applicationProperties;
   //     private CatalogMetaDataDao catalogMetaDataDao;
        private final Counter counter = Metrics.counter("requests_total");
        private final Timer timer = Metrics.timer("requests_duration");

        ReactiveRedisOperations<String, JsonNode> redisOperationsForCatalogApi;

//    public CatalogMetaDataService(BncTransactionDao bncTransactionDao,
//                                  @Autowired(required = false) ReactiveRedisOperations<String, JsonNode> redisOperationsForCatalogApi,
//                                  ApplicationProperties applicationProperties) {
//        this.catalogMetaDataDao = catalogMetaDataDao;
//        this.redisOperationsForCatalogApi = redisOperationsForCatalogApi;
//        this.applicationProperties = applicationProperties;
//    }

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final ObjectMapper objectMapper;
    public CatalogMetaDataService(ReactiveMongoTemplate reactiveMongoTemplate,ObjectMapper objectMapper) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.objectMapper = objectMapper;
    }
//    public Flux<JsonNode> fetchAllData() {
//        return reactiveMongoTemplate.find(new Query(), JsonNode.class, "c360_catalog_metadata");
//    }

    public Flux<JsonNode> fetchAllData() {
        Query query = new Query();
        query.fields().exclude("_id");
        return reactiveMongoTemplate.find(query, Map.class, "c360_catalog_metadata")
                .map(document -> objectMapper.convertValue(document, JsonNode.class));
    }

    }

