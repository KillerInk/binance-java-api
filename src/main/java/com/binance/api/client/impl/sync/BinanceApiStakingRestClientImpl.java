package com.binance.api.client.impl.sync;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.getTime;

import com.binance.api.client.api.BinanceStakingApiService;
import com.binance.api.client.api.sync.BinanceApiStakingRestClient;
import com.binance.api.client.domain.staking.StakingPersonalQuotaLeft;
import com.binance.api.client.domain.staking.StakingPosition;
import com.binance.api.client.domain.staking.StakingProduct;
import com.binance.api.client.domain.staking.StakingPurchaseResponse;
import com.binance.api.client.domain.staking.StakingRecord;
import com.binance.api.client.domain.staking.StakingRedeemResponse;
import com.binance.api.client.impl.BinanceApiServiceGenerator;

import java.util.List;

public class BinanceApiStakingRestClientImpl implements BinanceApiStakingRestClient {

    private final BinanceStakingApiService binanceApiService;

    public BinanceApiStakingRestClientImpl(String apiKey, String secret, String apiUrl) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceStakingApiService.class, apiKey, secret, apiUrl);
    }

    @Override
    public List<StakingProduct> getStakingProductList(String product, String asset, Long current, Long size, Long recvWindow) {
        return executeSync(binanceApiService.getStakingProductList(product,asset,current,size,recvWindow,getTime()));
    }

    @Override
    public StakingPurchaseResponse purchaseStakingProduct(String product, String productId, Long amount, String renewable, Long recvWindow) {
        return executeSync(binanceApiService.purchaseStakingProduct(product,productId,amount,renewable,recvWindow,getTime()));
    }

    @Override
    public StakingRedeemResponse redeemStakingProduct(String product, String positionId, String productId, Long amount, Long recvWindow) {
        return executeSync(binanceApiService.redeemStakingProduct(product,positionId,productId,amount,recvWindow,getTime()));
    }

    @Override
    public List<StakingPosition> getPositionsStaking(String product, String productId, String asset, Long current, Long size, Long recvWindow) {
        return executeSync(binanceApiService.getPositionsStaking(product,productId,asset,current,size,recvWindow,getTime()));
    }

    @Override
    public List<StakingRecord> getStakingRecord(String product, String txnType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow) {
        return executeSync(binanceApiService.getStakingRecord(product,txnType,asset,startTime,endTime,current,size,recvWindow,getTime()));
    }

    @Override
    public StakingRedeemResponse setAutoStaking(String product, String positionId, String renewable, Long recvWindow) {
        return executeSync(binanceApiService.setAutoStaking(product,positionId,renewable,recvWindow,getTime()));
    }

    @Override
    public StakingPersonalQuotaLeft getPersonalQuotaLeft(String product, String productId, Long recvWindow) {
        return executeSync(binanceApiService.getPersonalQuotaLeft(product,productId,recvWindow,getTime()));
    }
}
