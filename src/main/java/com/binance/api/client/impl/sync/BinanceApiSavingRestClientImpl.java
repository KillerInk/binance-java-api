package com.binance.api.client.impl.sync;

import com.binance.api.client.api.BinanceApiService;
import com.binance.api.client.api.BinanceSavingApiService;
import com.binance.api.client.api.sync.BinanceApiSavingRestClient;
import com.binance.api.client.domain.saving.InterestHistory;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.saving.RedemptionRecord;
import com.binance.api.client.impl.BinanceApiServiceGenerator;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.getTime;

public class BinanceApiSavingRestClientImpl implements BinanceApiSavingRestClient {

    private final BinanceSavingApiService binanceApiService;

    public BinanceApiSavingRestClientImpl(String apiKey, String secret, String apiUrl) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceSavingApiService.class, apiKey, secret, apiUrl);
    }

    @Override
    public List<RedemptionRecord> getRedemptionRecord(String lendingType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow) {
        return executeSync(binanceApiService.getRedemptionRecord(lendingType,asset,startTime,endTime,current,size,recvWindow,getTime()));
    }

    @Override
    public List<PurchaseRecord> getPurchaseRecord(String lendingType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow) {
        return executeSync(binanceApiService.getPurchaseRecord(lendingType,asset,startTime,endTime,current,size,recvWindow,getTime()));
    }

    @Override
    public List<InterestHistory> getInterestHistory(String lendingType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow) {
        return executeSync(binanceApiService.getInterestHistory(lendingType,asset,startTime,endTime,current,size,recvWindow,getTime()));
    }
}
