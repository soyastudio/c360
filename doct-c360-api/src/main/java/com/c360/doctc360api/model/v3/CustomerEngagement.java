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
public class CustomerEngagement {

    @JsonProperty("eng_mode_p3m")
    @Field("eng_mode_p3m")
    private String engModeP3m;

    @JsonProperty("eng_mode_p6m")
    @Field("eng_mode_p6m")
    private String engModeP6m;

    @JsonProperty("eng_mode_p12m")
    @Field("eng_mode_p12m ")
    private String engModeP12m;

    @JsonProperty("eng_mode_lifetime")
    @Field("eng_mode_lifetime")
     private String engModeLifetime;

    @JsonProperty("digital_login_p12m")
    @Field("digital_login_p12m")
    private String digitalLoginP12m;

}