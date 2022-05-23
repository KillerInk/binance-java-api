package com.binance.api.client.factory;

import com.binance.api.client.api.async.BinanceApiStakingAsyncRestClient;
import com.binance.api.client.api.sync.BinanceApiStakingRestClient;
import com.binance.api.client.impl.sync.BinanceApiSavingRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiStakingRestClientImpl;

public class BinanceStakingApiClientFactory implements BinanceFactory<BinanceApiStakingRestClient, BinanceApiStakingAsyncRestClient> {

    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    private final String apiUrl;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceStakingApiClientFactory(String apiKey, String secret, String apiUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiUrl = apiUrl;
    }

    public static BinanceStakingApiClientFactory newInstance(String apiKey, String secretKey, String apiUrl) {
        return new BinanceStakingApiClientFactory(apiKey, secretKey, apiUrl);
    }

    @Override
    public BinanceApiStakingAsyncRestClient newAsyncRestClient() {
        return null;
    }

    @Override
    public BinanceApiStakingRestClient newRestClient() {
        return new BinanceApiStakingRestClientImpl(apiKey, secret, apiUrl);
    }
}
