package com.c360.doctc360api.dao.impl;

import com.c360.doctc360api.dao.UserDataAccessLayer;
import com.c360.doctc360api.exception.NoDataFoundException;
import com.c360.doctc360api.model.C360CustomerDataModel;
import com.c360.doctc360api.repository.C360CustomerInfoModelRepository;
import com.c360.doctc360api.repository.C360DailyTransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Qualifier("UserDataDaoImpl")
public class UserDataDaoImpl implements UserDataAccessLayer {
    private static final Logger log = LoggerFactory.getLogger(UserDataDaoImpl.class);

    private final C360CustomerInfoModelRepository c360CustomerDataRepository;
    private final C360DailyTransactionsRepository dailyTransactionsRepository;

    public UserDataDaoImpl(C360CustomerInfoModelRepository c360CustomerDataRepository,
                           C360DailyTransactionsRepository dailyTransactionsRepository) {
        this.dailyTransactionsRepository = dailyTransactionsRepository;
        this.c360CustomerDataRepository = c360CustomerDataRepository;
    }

    @Override
    public Mono<C360CustomerDataModel> getMealPreferencesDetails(String uuid) {
        return c360CustomerDataRepository.findById(uuid)
                .switchIfEmpty(Mono.error(new NoDataFoundException(uuid)));
    }
}