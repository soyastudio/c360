package com.c360.doctc360api.controller;

import com.c360.doctc360api.exception.InvalidDataException;
import com.c360.doctc360api.model.C360CustomerDataModel;
import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import com.c360.doctc360api.model.TransactionsResponse;
import com.c360.doctc360api.service.C360CustomerDataService;
import com.c360.doctc360api.service.C360CustomerProfileServiceV2;
import com.c360.doctc360api.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.Date;

@RestController
public class C360CustomerProfileController {

    private final C360CustomerDataService c360CustomerDataService;
    private final C360CustomerProfileServiceV2 c360CustomerProfileService;

    public C360CustomerProfileController(C360CustomerDataService c360CustomerDataService, C360CustomerProfileServiceV2 c360CustomerProfileService) {
        this.c360CustomerDataService = c360CustomerDataService;
        this.c360CustomerProfileService = c360CustomerProfileService;
    }

    @GetMapping(value = "/v1/customer_info/{uuid}")
    public ResponseEntity<Mono<C360CustomerDataModel>> getCustomerData(@PathVariable String uuid) {
        return c360CustomerDataService.getCustomerData(uuid);
    }

    @GetMapping(value = "/v2/customer_info/{uuid}")
    public ResponseEntity<Mono<CustomerProfileResponse>> getProfileData(@PathVariable String uuid) {
        return c360CustomerProfileService.getProfileData(uuid);
    }


    @GetMapping("/v1/customer_transaction_aggregates/{uuid}")
    public ResponseEntity<Mono<TransactionsResponse>> getDailyTransactionByUuid(@PathVariable String uuid,
                                                                                @RequestParam (value = "startDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                                                @RequestParam (value = "endDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) throws InvalidDataException {

       if(startDate == null && endDate != null) {
            throw new InvalidDataException("Please enter Start Date!");
        }

        if(startDate != null && endDate != null && startDate.after(endDate)) {
            throw new InvalidDataException("End Date should be after Start Date!");
        }
        if(startDate != null) {
            startDate = DateUtils.addDays(startDate, -1);
        }

        if(startDate != null && (endDate == null || startDate.equals(endDate))) {
            endDate = DateUtils.addDays(startDate, 1);
        }
        return ResponseEntity.ok(c360CustomerDataService.getDailyTransactionByUuidAndDate(uuid, startDate, endDate)
                                    .switchIfEmpty(Mono.empty()));
    }
}