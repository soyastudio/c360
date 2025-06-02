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
public class CustomerSheerIdIdentification {

    @JsonProperty("student_ind")
    @Field("student_ind")
    private Boolean studentInd;

    @JsonProperty("snap_ind")
    @Field("snap_ind")
    private Boolean snapInd;

    @JsonProperty("snap_expire_ts")
    @Field("snap_expire_ts")
    private String snapExpireTs;

    @JsonProperty("snap_txn_ind")
    @Field("snap_txn_ind")
    private Boolean snapTxnInd;

    @JsonProperty("military_type")
    @Field("military_type")
    private String militaryType;

    @JsonProperty("firstresponder_ind")
    @Field("firstresponder_ind")
    private Boolean firstresponderInd;

    @JsonProperty("senior_ind")
    @Field("senior_ind")
    private Boolean seniorInd;

    @JsonProperty("medical_ind")
    @Field("medical_ind")
    private Boolean medicalInd;
}