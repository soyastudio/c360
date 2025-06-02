package com.c360.doctc360api.model;

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
public class EngagementMode {

    @JsonProperty("eng_mode_p3m")
    @Field("eng_mode_p3m")
    private String engmentMode3months;

    @JsonProperty("eng_mode_p6m")
    @Field("eng_mode_p6m")
    private String engmentMode6months;

    @JsonProperty("eng_mode_p12m")
    @Field("eng_mode_p12m")
    private String engmentMode12months;

    @JsonProperty("eng_mode_lifetime")
    @Field("eng_mode_lifetime")
    private String engagmentModeLifetime;
}
