package com.c360.doctc360api.model;

import com.c360.doctc360api.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DailyTransactionsResponse {

    @JsonProperty("transaction_date")
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD)
    private Date transactionDate;

    @JsonProperty("own_brand_total_txn_cnt")
    private int ownBrandTotalTxnCnt;

    @JsonProperty("dug_txn_cnt")
    private int dugTxnCnt;

    @JsonProperty("delivery_txn_cnt")
    private int deliveryTxnCnt;

    @JsonProperty("alcohol_purchase_net_amount")
    private double alcoholPurchaseNetAmount;

    @JsonProperty("alcohol_purchase_transaction_cnt")
    @Field("alcohol_purchase_transaction_cnt")
    private double alcoholPurchaseTransactioncnt;

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
