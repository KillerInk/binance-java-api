package com.binance.api.client.api.sync;

import com.binance.api.client.domain.staking.StakingPersonalQuotaLeft;
import com.binance.api.client.domain.staking.StakingPosition;
import com.binance.api.client.domain.staking.StakingProduct;
import com.binance.api.client.domain.staking.StakingPurchaseResponse;
import com.binance.api.client.domain.staking.StakingRecord;
import com.binance.api.client.domain.staking.StakingRedeemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Query;

public interface BinanceApiStakingRestClient {
    List<StakingProduct> getStakingProductList(
            String product,
            String asset,
            Long current,
            Long size,
            Long recvWindow
    );

    StakingPurchaseResponse purchaseStakingProduct(
            String product,
            String productId,
            Long amount,
            String renewable,
            Long recvWindow
    );

    StakingRedeemResponse redeemStakingProduct(
            String product,
            String positionId,
            String productId,
            Long amount,
            Long recvWindow
    );

    List<StakingPosition> getPositionsStaking(
            String product,
            String productId,
            String asset,
            Long current,
            Long size,
            Long recvWindow
    );

    List<StakingRecord> getStakingRecord(
            String product,
            String txnType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow
    );

    StakingRedeemResponse setAutoStaking(
            String product,
            String positionId,
            String renewable,
            Long recvWindow
    );

    StakingPersonalQuotaLeft getPersonalQuotaLeft(
            String product,
            String productId,
            Long recvWindow
    );
}
