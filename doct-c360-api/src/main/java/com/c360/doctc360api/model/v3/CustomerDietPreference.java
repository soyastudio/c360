package com.c360.doctc360api.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerDietPreference {

    @JsonProperty("inferred_diet_cd")
    @Field("inferred_diet_cd")
    private String inferredDietCd;

    @JsonProperty("explicit_diet_preference_cd")
    @Field("explicit_diet_preference_cd")
    private String explicitDietPreferenceCd;

    @JsonProperty("account_explicit_diet_preferences")
    @Field("account_explicit_diet_preferences")
    private List<String> accountExplicitDietPreferences;

    @JsonProperty("account_explicit_diet_restrictions")
    @Field("account_explicit_diet_restrictions")
    private List<String> accountExplicitDietRestrictions;


}