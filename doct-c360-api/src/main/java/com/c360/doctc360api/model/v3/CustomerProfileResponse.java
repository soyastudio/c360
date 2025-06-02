package com.c360.doctc360api.model.v3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Document(collection = "c360_customer_profile_v3")
public class CustomerProfileResponse {

    @Field("customer_profile")
    private CustomerProfile customerProfile;

    @Field("customer_purchase_indicator")
    private CustomerPurchaseIndicator customerPurchaseIndicator;

    @Field("customer_engagement")
    private CustomerEngagement customerEngagement;

    @Field("customer_store_region_preference")
    private CustomerStoreRegionPreference customerStoreRegionPreference;

    @Field("customer_communication_preference")
    private CustomerCommunicationPreference customerCommunicationPreference;

    @Field("customer_subscription")
    private CustomerSubscription customerSubscription;

    @Field("customer_transaction_dates")
    private CustomerTransactionDates customerTransactionDates;

    @Field("customer_diet_preference")
    private CustomerDietPreference customerDietPreference;

    @Field("customer_rewards")
    private CustomerRewards customerRewards;

    @Field("customer_sheer_id_identification")
    private CustomerSheerIdIdentification customerSheerIdIdentification;

    @Field("customer_symphony_segment")
    private CustomerSymphonySegment customerSymphonySegment;

    @Field("customer_celebrations_predictions")
    private CustomerCelebrationsPredictions customerCelebrationsPredictions;

    @Field("data_science_model")
    private DataScienceModel dataScienceModel;

}