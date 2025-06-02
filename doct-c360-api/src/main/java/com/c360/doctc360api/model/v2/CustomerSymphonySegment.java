package com.c360.doctc360api.model.v2;

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
public class CustomerSymphonySegment {

    @JsonProperty("weekly_fact_segment_dsc")
    @Field("weekly_fact_segment_dsc")
    private String weeklyFactSegmentDsc;

    @JsonProperty("shopstyles_segment_dsc")
    @Field("shopstyles_segment_dsc")
    private String shopstylesSegmentDsc;

    @JsonProperty("true_price_segment_period_dsc")
    @Field("true_price_segment_period_dsc")
    private String truePriceSegmentPeriodDsc;

    @JsonProperty("myneed_segment_dsc")
    @Field("myneed_segment_dsc")
    private String myneedSegmentDsc;

}