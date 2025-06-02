package com.c360.doctc360api.controller;

import com.c360.doctc360api.model.v3.CustomerProfileResponse;
import com.c360.doctc360api.service.C360CustomerProfileV3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class C360CustomerProfileV3Controller {

    private final C360CustomerProfileV3Service c360CustomerProfileService;

    public C360CustomerProfileV3Controller(C360CustomerProfileV3Service c360CustomerProfileService) {
            this.c360CustomerProfileService = c360CustomerProfileService;
    }

    @GetMapping(value = "/v3/customer_info/{uuid}")
    public ResponseEntity<Mono<CustomerProfileResponse>> getProfileData(@PathVariable String uuid) {
        return c360CustomerProfileService.getProfileData(uuid);
    }


}