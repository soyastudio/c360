package com.c360.doctc360api.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class CustomerStoreRegionPreference {

    @JsonProperty("customer_first_used_store_id")
    @Field("customer_first_used_store_id")
    private String customerFirstUsedStoreId;

    @JsonProperty("customer_most_used_store_id")
    @Field("customer_most_used_store_id")
    private String customerMostUsedStoreId;

    @JsonProperty("customer_highest_spent_store_id")
    @Field("customer_highest_spent_store_id")
    private String customerHighestSpentStoreId;

    @JsonProperty("prim_store_id")
    @Field("prim_store_id")
    private String primStoreId;

    @JsonProperty("prim_b4u_region_id")
    @Field("prim_b4u_region_id")
    private String primB4uRegionId;

    @JsonProperty("prim_division_id")
    @Field("prim_division_id")
    private String primDivisionId;

    @JsonProperty("pref_store_id")
    @Field("pref_store_id")
    private String prefStoreId;

    @JsonProperty("pref_b4u_region_id")
    @Field("pref_b4u_region_id")
    private String prefB4uRegionId;

    @JsonProperty("pref_division_id")
    @Field("pref_division_id")
    private String prefDivisionId;

    @JsonProperty("reg_ts")
    @Field("reg_ts")
    private Date regTs;

    @JsonProperty("reg_dt")
    @Field("reg_dt")
    private Date regDt;

    @JsonProperty("reg_store_id")
    @Field("reg_store_id")
    private String regStoreId;

    @JsonProperty("reg_b4u_region_id")
    @Field("reg_b4u_region_id")
    private String regB4uRegionId;

    @JsonProperty("reg_division_id")
    @Field("reg_division_id")
    private String regDivisionId;

    @JsonProperty("reg_report_ind")
    @Field("reg_report_ind")
    private Boolean regReportInd;

}