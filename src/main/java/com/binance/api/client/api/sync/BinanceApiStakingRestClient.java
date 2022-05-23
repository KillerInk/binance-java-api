package com.binance.api.client.api.sync;

import com.binance.api.client.domain.staking.StakingProduct;

import java.util.List;

public interface BinanceApiStakingRestClient {
    List<StakingProduct> getStakingProductList(
            String product,
            String asset,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp
    );
}
