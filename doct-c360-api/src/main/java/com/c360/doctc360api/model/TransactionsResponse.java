package com.c360.doctc360api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TransactionsResponse {
    private String uuid;
    private List<DailyTransactionsResponse> transactions;
}
