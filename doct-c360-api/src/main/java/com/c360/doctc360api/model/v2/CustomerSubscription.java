package com.c360.doctc360api.model.v2;

import com.c360.doctc360api.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.sql.Timestamp;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class CustomerSubscription {

    @JsonProperty("freshpass_subscription_status_cd")
    @Field("freshpass_subscription_status_cd")
    private String freshpassSubscriptionStatusCd;

    @JsonProperty("freshpass_subscription_dt")
    @Field("freshpass_subscription_dt")
    private String  freshpassSubscriptionDt;

    @JsonProperty("schedule_and_save_ind")
    private Boolean scheduleAndSaveInd;

}