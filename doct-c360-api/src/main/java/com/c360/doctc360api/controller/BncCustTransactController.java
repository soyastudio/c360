package com.c360.doctc360api.controller;

import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import com.c360.doctc360api.service.bnc.BncCustTransService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BncCustTransactController {

    private final BncCustTransService c360FulfillmentService;


    public BncCustTransactController(BncCustTransService c360FulfillmentService) {
        this.c360FulfillmentService = c360FulfillmentService;
    }

    @GetMapping(value = "/v1/bnc/{uuid}")
    public ResponseEntity<Mono<BncTransactionDataModel>> getCustomerData(@PathVariable String uuid) {
        return c360FulfillmentService.getBncTransactionData(uuid);
    }
}