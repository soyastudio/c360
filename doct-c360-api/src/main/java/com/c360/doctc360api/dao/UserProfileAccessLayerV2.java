package com.c360.doctc360api.dao;

import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import reactor.core.publisher.Mono;

public interface UserProfileAccessLayerV2 {
    Mono<CustomerProfileResponse> getCustomerDetails(String customerUUID);
}