package com.c360.doctc360api.controller;

import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import com.c360.doctc360api.service.bnc.BncCustTransService;
import com.c360.doctc360api.service.catalog.CatalogMetaDataService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CatalogMetaApiController {

    private final CatalogMetaDataService catalogMetaDataService;

    public CatalogMetaApiController(CatalogMetaDataService catalogMetaDataService) {
        this.catalogMetaDataService = catalogMetaDataService;
    }

    @GetMapping(value = "/v1/catalog/all")
    public ResponseEntity<Flux<JsonNode>> getMetaData() {
        return ResponseEntity.ok(catalogMetaDataService.fetchAllData());
    }
}