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

public class CustomerCommunicationPreference {

    @JsonProperty("push_enabled_ind")
    @Field("push_enabled_ind")
    private Boolean pushEnabledInd;

    @JsonProperty("email_opt_in_dt")
    @Field("email_opt_in_dt")
    private String emailOptInDt;

    @JsonProperty("sms_opt_in")
    @Field("sms_opt_in")
    private String smsOptIn;

    @JsonProperty("sms_opt_in_dt")
    @Field("sms_opt_in_dt")
    private String smsOptInDt;

    @JsonProperty("marketable_email_ind")
    @Field("marketable_email_ind")
    private String marketableEmailInd;

}