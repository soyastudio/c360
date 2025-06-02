package com.c360.doctc360api.model.v2;

import com.c360.doctc360api.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class CustomerRewards {

    @JsonProperty("auto_cash_status_ind")
    @Field("auto_cash_status_ind")
    private Boolean autoCashStatusInd;

    @JsonProperty("current_point_balance")
    @Field("current_point_balance")
    private String  currentPointBalance;

    @JsonProperty("auto_cash_last_toggle_dt")
    @Field("auto_cash_last_toggle_dt")
    private String autoCashLastToggleDt;

    @JsonProperty("auto_cash_cashoff_earned_since_optin")
    @Field("auto_cash_cashoff_earned_since_optin")
    private String  autoCashCashoffEarnedSinceOptin;

    @JsonProperty("auto_cash_any_clip_ind")
    @Field("auto_cash_any_clip_ind")
    private Boolean autoCashAnyClipInd;

    @JsonProperty("lifetime_savings_amt")
    @Field("lifetime_savings_amt")
    private String lifetimeSavingsAmt;

    @JsonProperty("points_expiring_next_month")
    @Field("points_expiring_next_month")
    private String  pointsExpiringNextMonth;
}