package com.c360.doctc360api.dao;

import com.c360.doctc360api.model.v3.CustomerProfileResponse;
import reactor.core.publisher.Mono;

public interface UserProfileAccessLayerV3 {
    Mono<CustomerProfileResponse> getCustomerDetails(String customerUUID);
}