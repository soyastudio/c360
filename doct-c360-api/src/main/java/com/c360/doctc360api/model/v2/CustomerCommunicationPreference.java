package com.c360.doctc360api.model.v2;

import com.c360.doctc360api.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor

public class CustomerCommunicationPreference {

    @JsonProperty("mail_preference")
    @Field("mail_preference")
    private String mailPreference;

    @JsonProperty("email_validated_ind")
    @Field("email_validated_ind")
    private Boolean emailValidatedInd;

    @JsonProperty("sms_validated_ind")
    @Field("sms_validated_ind")
    private Boolean smsValidatedInd;

    @JsonProperty("validated_phone_type")
    @Field("validated_phone_type")
    private String validatedPhoneType;

    @JsonProperty("email_verified_ind")
    @Field("email_verified_ind")
    private Boolean emailVerifiedInd;

    @JsonProperty("sms_verified_ind")
    @Field("sms_verified_ind")
    private Boolean smsVerifiedInd;

    @JsonProperty("push_enabled_ind")
    @Field("push_enabled_ind")
    private Boolean pushEnabledInd;

    @JsonProperty("email_opt_in_verified_ind")
    @Field("email_opt_in_verified_ind")
    private Boolean emailOptInVerifiedInd;

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

    @JsonProperty("sms_launch_target_ind")
    private Boolean smsLaunchTargetInd;

}