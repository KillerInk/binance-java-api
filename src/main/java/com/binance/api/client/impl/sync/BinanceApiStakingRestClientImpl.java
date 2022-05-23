package com.binance.api.client.impl.sync;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.getTime;

import com.binance.api.client.api.BinanceStakingApiService;
import com.binance.api.client.api.sync.BinanceApiStakingRestClient;
import com.binance.api.client.domain.staking.StakingProduct;
import com.binance.api.client.impl.BinanceApiServiceGenerator;

import java.util.List;

public class BinanceApiStakingRestClientImpl implements BinanceApiStakingRestClient {

    private final BinanceStakingApiService binanceApiService;

    public BinanceApiStakingRestClientImpl(String apiKey, String secret, String apiUrl) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceStakingApiService.class, apiKey, secret, apiUrl);
    }

    @Override
    public List<StakingProduct> getStakingProductList(String product, String asset, Long current, Long size, Long recvWindow, Long timestamp) {
        return executeSync(binanceApiService.getStakingProductList(product,asset,current,size,recvWindow,getTime()));
    }
}
