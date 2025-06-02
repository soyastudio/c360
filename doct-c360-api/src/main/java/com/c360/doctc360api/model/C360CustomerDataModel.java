package com.c360.doctc360api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "c360_customer_profile")
@NoArgsConstructor
@ToString
@Setter
@Getter
public class C360CustomerDataModel {

    @Id
    @JsonIgnore
    private String id;


    private String uuid;
    private String guid;

    @JsonProperty("household_id")
    @Field("household_id")
    private String householdId;

    @JsonProperty("club_card_nbr")
    @Field("club_card_nbr")
    private String clubCardNbr;


    @JsonProperty("meal_preferences")
    @Field("meal_preferences")
    private MealPreferences mealPreferences;

    private FreshPass freshPass;

    private Indicators indicators;

    @JsonProperty("eng_mode")
    @Field("eng_mode")
    private EngagementMode engagementMode;


}
