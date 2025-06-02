package com.c360.doctc360api.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class FreshPass {

    @Field("freshpass_subscription_status_cd")
    private String freshpass_subscription_status_cd;
}
