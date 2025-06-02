package com.c360.doctc360api.model.v3;

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
public class DataScienceModel {

    @JsonProperty("model_attribute")
    @Field("model_attribute")
    private String modelAttribute;

    @JsonProperty("model_value_string")
    @Field("model_value_string")
    private String modelValueString;

    @JsonProperty("model_value_integer")
    @Field("model_value_integer")
    private Integer modelValueInteger;

    @JsonProperty("model_value_float")
    @Field("model_value_float")
    private Float modelValueFloat;

    @JsonProperty("model_value_boolean")
    @Field("model_value_boolean")
    private Boolean modelValueBoolean;

    @JsonProperty("added_timestamp")
    @Field("added_timestamp")
    private Date addedTimestamp;
}