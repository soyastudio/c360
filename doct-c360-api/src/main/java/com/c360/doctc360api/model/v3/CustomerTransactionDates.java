package com.c360.doctc360api.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerTransactionDates {
    @JsonProperty("last_web_visit_dt")
    @Field("last_web_visit_dt")
    private String lastWebVisitDt;

    @JsonProperty("last_mobile_visit_dt")
    @Field("last_mobile_visit_dt")
    private String lastMobileVisitDt;

    @JsonProperty("last_store_visit_dt")
    @Field("last_store_visit_dt")
    private String lastStoreVisitDt;

}