package com.c360.doctc360api.dao;

import com.c360.doctc360api.model.C360CustomerDataModel;
import reactor.core.publisher.Mono;

public interface UserDataAccessLayer {
   Mono<C360CustomerDataModel> getMealPreferencesDetails(String uuid);
//   Mono<CustomerProfileResponse> getCustomerDetails(String customerUUID);
}