package com.binance.api.client.api.sync;

import com.binance.api.client.domain.saving.InterestHistory;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.saving.RedemptionRecord;

import java.util.List;

public interface BinanceApiSavingRestClient {

    List<RedemptionRecord> getRedemptionRecord (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow);

    List<PurchaseRecord> getPurchaseRecord (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow
    );

    List<InterestHistory> getInterestHistory (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow
    );

}
