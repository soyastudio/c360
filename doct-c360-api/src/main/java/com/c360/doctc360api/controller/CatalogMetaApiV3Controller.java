package com.c360.doctc360api.controller;

import com.c360.doctc360api.service.catalog.CatalogMetaDataV3Service;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CatalogMetaApiV3Controller {

    private final CatalogMetaDataV3Service catalogMetaDataService;

    public CatalogMetaApiV3Controller(CatalogMetaDataV3Service catalogMetaDataService) {
        this.catalogMetaDataService = catalogMetaDataService;
    }

    @GetMapping(value = "/v3/catalog/all")
    public ResponseEntity<Flux<JsonNode>> getMetaData() {
        return ResponseEntity.ok(catalogMetaDataService.fetchAllData());
    }
}