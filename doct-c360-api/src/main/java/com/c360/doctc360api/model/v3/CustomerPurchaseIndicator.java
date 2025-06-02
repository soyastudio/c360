package com.c360.doctc360api.model.v3;

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

    @JsonProperty("pharmacy_purchase_ind_6m")
    @Field("pharmacy_purchase_ind_6m")
    private Boolean pharmacyPurchaseInd;

    @JsonProperty("gas_rewards_ind_6m")
    @Field("gas_rewards_ind_6m")
    private Boolean gasRewardsInd;

    @JsonProperty("alcohol_purchase_ind_6m")
    @Field("alcohol_purchase_ind_6m")
    private Boolean alcoholPurchaseInd;

    @JsonProperty("pet_product_purchase_ind_6m")
    @Field("pet_product_purchase_ind_6m")
    private Boolean petProductPurchaseInd;

    @JsonProperty("own_brand_ind_6m")
    @Field("own_brand_ind_6m")
    private Boolean ownBrandInd;

    @JsonProperty("deal_clipped_ind_6m")
    @Field("deal_clipped_ind_6m")
    private Boolean dealClippedInd;

    @JsonProperty("baby_product_purchase_ind_6m")
    @Field("baby_product_purchase_ind_6m")
    private Boolean babyProductPurchaseInd;

    @JsonProperty("starbucks_purchase_ind_6m")
    @Field("starbucks_purchase_ind_6m")
    private Boolean starbucksPurchaseInd;

    @JsonProperty("delicatessen_purchase_ind_6m")
    @Field("delicatessen_purchase_ind_6m")
    private Boolean delicatessenPurchaseInd;

    @JsonProperty("produce_purchase_ind_6m")
    @Field("produce_purchase_ind_6m")
    private Boolean producePurchaseInd;

    @JsonProperty("food_service_purchase_ind_6m")
    @Field("food_service_purchase_ind_6m")
    private String foodServiceIn;

    @JsonProperty("frozen_grocery_purchase_ind_6m")
    @Field("frozen_grocery_purchase_ind_6m")
    private Boolean frozenGroceryPurchaseInd;

    @JsonProperty("bakery_packed_outside_purchase_ind_6m")
    @Field("bakery_packed_outside_purchase_ind_6m")
    private Boolean bakeryPackedOutsidePurchaseInd;

    @JsonProperty("dairy_purchase_ind_6m")
    @Field("dairy_purchase_ind_6m")
    private Boolean dairyPurchaseInd;

    @JsonProperty("bakery_purchase_ind_6m")
    @Field("bakery_purchase_ind_6m")
    private Boolean bakeryPurchaseInd;

    @JsonProperty("coffee_kiosk_purchase_ind_6m")
    @Field("coffee_kiosk_purchase_ind_6m")
    private Boolean coffeeKioskPurchaseInd;

    @JsonProperty("seafood_purchase_ind_6m")
    @Field("seafood_purchase_ind_6m")
    private Boolean seafoodPurchaseInd;

    @JsonProperty("catering_purchase_ind_6m")
    @Field("catering_purchase_ind_6m")
    private Boolean cateringPurchaseInd;

    @JsonProperty("gm_hbc_purchase_ind_6m")
    @Field("gm_hbc_purchase_ind_6m")
    private Boolean gmHbcPurchaseInd;

    @JsonProperty("plated_meal_kits_purchase_ind_6m")
    @Field("plated_meal_kits_purchase_ind_6m")
    private Boolean platedMealKitsPurchaseInd;

    @JsonProperty("meat_purchase_ind_6m")
    @Field("meat_purchase_ind_6m")
    private Boolean meatPurchaseInd;

    @JsonProperty("fuel_station_purchase_ind_6m")
    @Field("fuel_station_purchase_ind_6m")
    private Boolean fuelStationPurchaseInd;

    @JsonProperty("tobacco_purchase_ind_6m")
    @Field("tobacco_purchase_ind_6m")
    private Boolean tobaccoPurchaseInd;

    @JsonProperty("bar_purchase_ind_6m")
    @Field("bar_purchase_ind_6m")
    private Boolean barPurchaseInd;

    @JsonProperty("floral_purchase_ind_6m")
    @Field("floral_purchase_ind_6m")
    private Boolean floralPurchaseInd;

    @JsonProperty("ecom_purchase_ind_6m")
    @Field("ecom_purchase_ind_6m")
    private Boolean ecomPurchaseInd;
}