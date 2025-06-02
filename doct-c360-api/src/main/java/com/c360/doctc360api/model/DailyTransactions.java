package com.c360.doctc360api.model;

import com.c360.doctc360api.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "c360_daily_transactions")
@Getter
@Setter
@NoArgsConstructor
public class DailyTransactions {


    @Id
    private String _id;

    @JsonIgnoreProperties
    private String uuid;

    @JsonProperty("transaction_date")
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD)
    @Field("transaction_date")
    private Date transactionDate;

    @JsonProperty("own_brand_total_txn_cnt")
    @Field("own_brand_total_txn_cnt")
    private int ownBrandTotalTxnCnt;

    @JsonProperty("dug_txn_cnt")
    @Field("dug_txn_cnt")
    private int dugTxnCnt;

    @JsonProperty("delivery_txn_cnt")
    @Field("delivery_txn_cnt")
    private int deliveryTxnCnt;

    @JsonProperty("alcohol_purchase_net_amount")
    @Field("alcohol_purchase_net_amount")
    private double alcoholPurchaseNetAmount;

    @JsonProperty("alcohol_purchase_transaction_cnt")
    @Field("alcohol_purchase_transaction_cnt")
    private double alcoholPurchaseTransactioncnt;

}

