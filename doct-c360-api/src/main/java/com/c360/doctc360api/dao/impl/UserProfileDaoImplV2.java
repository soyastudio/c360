package com.c360.doctc360api.dao.impl;

import com.c360.doctc360api.dao.UserProfileAccessLayerV2;
import com.c360.doctc360api.exception.NoDataFoundException;
import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import com.c360.doctc360api.repository.C360CustomerProfileModelRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Qualifier("UserProfileDaoImpl")
public class UserProfileDaoImplV2 implements UserProfileAccessLayerV2 {
    private static final Logger log = LoggerFactory.getLogger(UserProfileDaoImplV2.class);

    private final C360CustomerProfileModelRespository customerProfileRespository;

    public UserProfileDaoImplV2(C360CustomerProfileModelRespository customerProfileRespository) {
        this.customerProfileRespository = customerProfileRespository;
    }

    @Override
    public Mono<CustomerProfileResponse> getCustomerDetails(String customerUUID) {
        return customerProfileRespository.findById(customerUUID)
                .switchIfEmpty(Mono.error(new NoDataFoundException(customerUUID)));
    }
}