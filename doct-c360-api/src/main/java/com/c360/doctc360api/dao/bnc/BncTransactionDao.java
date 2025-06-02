package com.c360.doctc360api.dao.bnc;

import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import reactor.core.publisher.Mono;

public interface BncTransactionDao {

    Mono<BncTransactionDataModel> getTransactionData(String customerUUID);
}