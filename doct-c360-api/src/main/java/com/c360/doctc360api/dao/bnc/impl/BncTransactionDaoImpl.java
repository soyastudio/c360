package com.c360.doctc360api.dao.bnc.impl;

import com.c360.doctc360api.dao.bnc.BncTransactionDao;
import com.c360.doctc360api.exception.NoDataFoundException;
import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import com.c360.doctc360api.repository.C360CustomerProfileModelRespository;
import com.c360.doctc360api.repository.bnc.BncCustTransModelRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BncTransactionDaoImpl implements BncTransactionDao {
    private static final Logger log = LoggerFactory.getLogger(BncTransactionDaoImpl.class);

    private final BncCustTransModelRespository bncCustTransModelRespository;

    public BncTransactionDaoImpl(BncCustTransModelRespository bncCustTransModelRespository) {
        this.bncCustTransModelRespository = bncCustTransModelRespository;
    }

    @Override
    public Mono<BncTransactionDataModel> getTransactionData(String customerUUID) {
        return bncCustTransModelRespository.findById(customerUUID)
                .switchIfEmpty(Mono.error(new NoDataFoundException(customerUUID)));
    }
}