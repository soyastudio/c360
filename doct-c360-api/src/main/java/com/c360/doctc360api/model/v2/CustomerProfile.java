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
public class CustomerProfile {

    @JsonProperty("uuid")
    @Field("uuid")
    private String uuid;

    @JsonProperty("hhid")
    @Field("hhid")
    private String hhid;

    @JsonProperty("guid")
    @Field("guid")
    private String guid;

    @JsonProperty("club_card_nbr")
    @Field("club_card_nbr")
    private String clubCard;

    @JsonProperty("b4u_profile_ind")
    @Field("b4u_profile_ind")
    private Boolean b4uProfileInd;

    @JsonProperty("b4u_sign_up_dt")
    @Field("b4u_sign_up_dt")
    private String b4uSignUpDt;

    @JsonProperty("sincerely_health_ind")
    @Field("sincerely_health_ind")
    private Boolean sincerelyHealthInd;

    @JsonProperty("birth_month")
    @Field("birth_month")
    private String birthMonth;
}
