package com.c360.doctc360api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Indicators {

    @JsonProperty("alcohol_purchase_indicator")
    @Field("alcohol_purchase_indicator")
    private Boolean alcoholPurchaseIndicator;

    @JsonProperty("new_customer_indicator")
    @Field("new_customer_indicator")
    private String newCustomerIndicator;

    @JsonProperty("ecomm_purchase_indicator")
    @Field("ecomm_purchase_indicator")
    private Boolean ecommPurchaseIndicator;

    @JsonProperty("dug_txn_indicator")
    @Field("dug_txn_indicator")
    private Boolean dugTxnIndicator;

    @JsonProperty("delivery_txn_indicator")
    @Field("delivery_txn_indicator")
    private Boolean deliveryTxnIndicator;

    @JsonProperty("own_brand_purchase_indicator")
    @Field("own_brand_purchase_indicator")
    private Boolean ownBrandPurchaseIndicator;

    @JsonProperty("ecomm_last_purchase_date")
    @Field("ecomm_last_purchase_date")
    private String ecommLastPurchaseDate;

    @JsonProperty("rewards_expired")
    @Field("rewards_expired")
    private String rewardsExpired;

    @JsonProperty("sincerely_health_ind")
    @Field("sincerely_health_ind")
    private Boolean sincerelyHealthInd;

}
