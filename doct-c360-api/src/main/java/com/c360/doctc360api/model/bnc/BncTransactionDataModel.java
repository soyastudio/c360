package com.c360.doctc360api.model.bnc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.OffsetDateTime;
import java.util.Date;


@Document(collection = "customer_last_transaction")
@NoArgsConstructor
@ToString
@Setter
@Getter
public class BncTransactionDataModel {

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty("customer_uuid")
    @Field("customer_uuid")
    private String uuid;

    @JsonProperty("customer_type")
    @Field("customer_type")
    private String customerType;

    @JsonProperty("last_Transaction_OrderDate")
    @Field("last_Transaction_OrderDate")
    private Date lastTransactionOrderDate;

    @JsonProperty("freshpass_status_cd")
    @Field("freshpass_status_cd")
    private String freshpassStatusCd;

    @JsonProperty("order_count")
    @Field("order_count")
    private String orderCount;

}
