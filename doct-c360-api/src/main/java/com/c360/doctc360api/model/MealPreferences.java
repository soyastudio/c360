package com.c360.doctc360api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class MealPreferences {

    @JsonProperty("inferred_diet_cd")
    @Field("inferred_diet_cd")
    private String inferredDietCd;

    @JsonProperty("classic_diet_preference_ind")
    @Field("classic_diet_preference_ind")
    private Boolean classicDietPreferenceInd;

    @JsonProperty("keto_friendly_diet_preference_ind")
    @Field("keto_friendly_diet_preference_ind")
    private Boolean ketoFriendlyDietPreferenceInd;

    @JsonProperty("flexitarian_diet_preference_ind")
    @Field("flexitarian_diet_preference_ind")
    private Boolean flexitarianDietPreferenceInd;

    @JsonProperty("paleo_friendly_diet_preference_ind")
    @Field("paleo_friendly_diet_preference_ind")
    private Boolean paleoFriendlyDietPreferenceInd;

    @JsonProperty("vegetarian_diet_preference_ind")
    @Field("vegetarian_diet_preference_ind")
    private Boolean vegetarianDietPreferenceInd;

    @JsonProperty("pescatarian_diet_preference_ind")
    @Field("pescatarian_diet_preference_ind")
    private Boolean pescatarianDietPreferenceInd;

    @JsonProperty("vegan_diet_preference_ind")
    @Field("vegan_diet_preference_ind")
    private Boolean veganDietPreferenceInd;

    @JsonProperty("carb_conscious_diet_preference_ind")
    @Field("carb_conscious_diet_preference_ind")
    private Boolean carbConsciousDietPreferenceInd;

    @JsonProperty("soy_free_restriction_ind")
    @Field("soy_free_restriction_ind")
    private Boolean soyFreeRestrictionInd;

    @JsonProperty("fish_free_restriction_ind")
    @Field("fish_free_restriction_ind")
    private Boolean fishFreeRestrictionInd;

    @JsonProperty("peanut_free_restriction_ind")
    @Field("peanut_free_restriction_ind")
    private Boolean peanutFreeRestrictionInd;

    @JsonProperty("tree_nut_free_restriction_ind")
    @Field("tree_nut_free_restriction_ind")
    private Boolean treeNutFreeRestrictionInd;

    @JsonProperty("shellfish_free_restriction_ind")
    @Field("shellfish_free_restriction_ind")
    private Boolean shellfishFreeRestriction_ind;

    @JsonProperty("dairy_free_restriction_ind")
    @Field("dairy_free_restriction_ind")
    private Boolean dairyFreeRestrictionInd;

    @JsonProperty("sulfite_free_restriction_ind")
    @Field("sulfite_free_restriction_ind")
    private Boolean sulfiteFreeRestrictionInd;

    @JsonProperty("mustard_free_restriction_ind")
    @Field("mustard_free_restriction_ind")
    private Boolean mustardFreeRestrictionInd;

    @JsonProperty("sesame_free_restriction_ind")
    @Field("sesame_free_restriction_ind")
    private Boolean sesameFreeRestrictionInd;

    @JsonProperty("egg_free_restriction_ind")
    @Field("egg_free_restriction_ind")
    private Boolean eggFreeRestrictionInd;

    @JsonProperty("nightshade_free_restriction_ind")
    @Field("nightshade_free_restriction_ind")
    private Boolean nightshadeFreeRestrictionInd;

    @JsonProperty("gluten_free_restriction_ind")
    @Field("gluten_free_restriction_ind")
    private Boolean glutenFreeRestrictionInd;

    @JsonProperty("account_explicit_diet_preferences")
    @Field("account_diet_preference")
    private List<String> accountDietPreference;

    @JsonProperty("account_explicit_diet_restrictions")
    @Field("account_diet_restrictions")
    private List<String> accountDietRestrictions;
}