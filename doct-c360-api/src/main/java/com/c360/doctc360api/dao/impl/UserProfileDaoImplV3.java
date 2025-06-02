package com.c360.doctc360api.dao.impl;

import com.c360.doctc360api.dao.UserProfileAccessLayerV3;
import com.c360.doctc360api.exception.NoDataFoundException;
import com.c360.doctc360api.model.v3.CustomerProfileResponse;
import com.c360.doctc360api.repository.C360CustomerInfoV3Repository;
import com.c360.doctc360api.repository.C360CustomerProfileModelRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Qualifier("UserProfileDaoImpl")
public class UserProfileDaoImplV3 implements UserProfileAccessLayerV3 {
    private static final Logger log = LoggerFactory.getLogger(UserProfileDaoImplV3.class);

    private final C360CustomerInfoV3Repository customerInfoV3Repository;

    public UserProfileDaoImplV3(C360CustomerInfoV3Repository customerInfoV3Repository) {
        this.customerInfoV3Repository = customerInfoV3Repository;
    }

    @Override
    public Mono<CustomerProfileResponse> getCustomerDetails(String customerUUID) {
        return customerInfoV3Repository.findById(customerUUID)
                .switchIfEmpty(Mono.error(new NoDataFoundException(customerUUID)));
    }
}