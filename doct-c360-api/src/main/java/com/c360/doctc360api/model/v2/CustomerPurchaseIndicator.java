package com.c360.doctc360api.model.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class CustomerPurchaseIndicator {

    @JsonProperty("in_store_txn_ind")
    @Field("in_store_txn_ind")
    private Boolean inStoreTxnInd;

    @JsonProperty("web_transacted_ind")
    @Field("web_transacted_ind")
    private Boolean webTransactedInd;

    @JsonProperty("mobile_transacted_ind")
    @Field("mobile_transacted_ind")
    private Boolean mobileTransactedInd;

    @JsonProperty("dug_ind")
    @Field("dug_ind")
    private Boolean dugInd;

    @JsonProperty("delivery_ind")
    @Field("delivery_ind")
    private Boolean deliveryInd;

    @JsonProperty("pharmacy_purchase_ind")
    @Field("pharmacy_purchase_ind")
    private Boolean pharmacyPurchaseInd;

    @JsonProperty("gas_rewards_ind")
    @Field("gas_rewards_ind")
    private Boolean gasRewardsInd;

    @JsonProperty("alcohol_purchase_ind")
    @Field("alcohol_purchase_ind")
    private Boolean alcoholPurchaseInd;

    @JsonProperty("pet_product_purchase_ind")
    @Field("pet_product_purchase_ind")
    private Boolean petProductPurchaseInd;

    @JsonProperty("own_brand_ind")
    @Field("own_brand_ind")
    private Boolean ownBrandInd;

    @JsonProperty("deal_clipped_ind")
    @Field("deal_clipped_ind")
    private Boolean dealClippedInd;

    @JsonProperty("baby_product_purchase_ind")
    @Field("baby_product_purchase_ind")
    private Boolean babyProductPurchaseInd;

    @JsonProperty("starbucks_purchase_ind")
    @Field("starbucks_purchase_ind")
    private Boolean starbucksPurchaseInd;

    @JsonProperty("delicatessen_purchase_ind")
    @Field("delicatessen_purchase_ind")
    private Boolean delicatessenPurchaseInd;

    @JsonProperty("produce_purchase_ind")
    @Field("produce_purchase_ind")
    private Boolean producePurchaseInd;

    @JsonProperty("food_service_purchase_ind")
    @Field("food_service_purchase_ind")
    private String foodServiceIn;

    @JsonProperty("frozen_grocery_purchase_ind")
    @Field("frozen_grocery_purchase_ind")
    private Boolean frozenGroceryPurchaseInd;

    @JsonProperty("bakery_packed_outside_purchase_ind")
    @Field("bakery_packed_outside_purchase_ind")
    private Boolean bakeryPackedOutsidePurchaseInd;

    @JsonProperty("dairy_purchase_ind")
    @Field("dairy_purchase_ind")
    private Boolean dairyPurchaseInd;

    @JsonProperty("bakery_purchase_ind")
    @Field("bakery_purchase_ind")
    private Boolean bakeryPurchaseInd;

    @JsonProperty("coffee_kiosk_purchase_ind")
    @Field("coffee_kiosk_purchase_ind")
    private Boolean coffeeKioskPurchaseInd;

    @JsonProperty("seafood_purchase_ind")
    @Field("seafood_purchase_ind")
    private Boolean seafoodPurchaseInd;

    @JsonProperty("catering_purchase_ind")
    @Field("catering_purchase_ind")
    private Boolean cateringPurchaseInd;

    @JsonProperty("gm_hbc_purchase_ind")
    @Field("gm_hbc_purchase_ind")
    private Boolean gmHbcPurchaseInd;

    @JsonProperty("plated_meal_kits_purchase_ind")
    @Field("plated_meal_kits_purchase_ind")
    private Boolean platedMealKitsPurchaseInd;

    @JsonProperty("meat_purchase_ind")
    @Field("meat_purchase_ind")
    private Boolean meatPurchaseInd;

    @JsonProperty("fuel_station_purchase_ind")
    @Field("fuel_station_purchase_ind")
    private Boolean fuelStationPurchaseInd;

    @JsonProperty("tobacco_purchase_ind")
    @Field("tobacco_purchase_ind")
    private Boolean tobaccoPurchaseInd;

    @JsonProperty("bar_purchase_ind")
    @Field("bar_purchase_ind")
    private Boolean barPurchaseInd;

    @JsonProperty("floral_purchase_ind")
    @Field("floral_purchase_ind")
    private Boolean floralPurchaseInd;

    @JsonProperty("ecom_purchase_ind")
    @Field("ecom_purchase_ind")
    private Boolean ecomPurchaseInd;
}