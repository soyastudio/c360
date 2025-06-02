package com.c360.doctc360api.model.v2;

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
public class CustomerCelebrationsPredictions {

    @JsonProperty("current_fiscal_week_id")
    @Field("current_fiscal_week_id")
    private Double currentFiscalWeekId;

    @JsonProperty("gen_celebration_pred")
    @Field("gen_celebration_pred")
    private Double genCelebrationPred;

    @JsonProperty("birthday_pred")
    @Field("birthday_pred")
    private Double birthdayPred;

    @JsonProperty("anniversary_pred")
    @Field("anniversary_pred")
    private Double anniversaryPred;



}