package com.binance.api.client.factory;

import com.binance.api.client.BinanceEngineType;
import com.binance.api.client.config.*;
import com.binance.api.client.exception.BinanceIllegalException;

/**
 * @author Mahdi Shiekh Hosseini
 */
public abstract class BinanceAbstractFactory {

    /**
     * General binance factory .
     * this method create a factory by type of engine you choose .
     *
     * @param apiKey
     * @param secretKey
     * @param engineType
     * @param apiConfigClass
     * @return instance of object extended BinanceFactory
     * @see BinanceApiConfig
     * @see BinanceEngineType
     */
    public static BinanceFactory createFactory(String apiKey, String secretKey, BinanceEngineType engineType, Class<? extends BinanceApiConfig> apiConfigClass) {
        final String apiUrl = getApiUrl(apiConfigClass);
        final String websocketUrl = getWebsocketUrl(apiConfigClass);
        switch (engineType) {
            case SPOT:
                return BinanceSpotApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
            case MARGIN:
                return BinanceMarginApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
            case SWAP:
                return BinanceSwapApiClientFactory.newInstance(apiKey, secretKey, apiUrl);
            case FUTURES:
            case TESTNET:
                return BinanceFuturesApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
        }
        throw new IllegalArgumentException();
    }

    /**
     * @param apiKey
     * @param secretKey
     * @param engineType
     * @return instance of object extended BinanceFactory
     * @see BinanceEngineType
     */
    public static BinanceFactory createFactory(String apiKey, String secretKey, BinanceEngineType engineType) {
        switch (engineType) {
            case SPOT:
                return createSpotFactory(apiKey, secretKey);
            case MARGIN:
                return createMarginFactory(apiKey, secretKey);
            case SWAP:
                return createSwapFactory(apiKey, secretKey);
            case FUTURES:
                return createFuturesFactory(apiKey, secretKey);
            case TESTNET:
                return createTestnetFactory(apiKey, secretKey);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Basic and simple create spot engine factory .
     *
     * @param apiKey
     * @param secretKey
     * @return instance of object extended BinanceFactory
     */
    public static BinanceSpotApiClientFactory createSpotFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(SpotApiConfig.class);
        final String websocketUrl = getWebsocketUrl(SpotApiConfig.class);
        return BinanceSpotApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    /**
     * Basic and simple create margin engine factory .
     *
     * @param apiKey
     * @param secretKey
     * @return instance of object extended BinanceFactory
     */
    public static BinanceMarginApiClientFactory createMarginFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(SpotApiConfig.class);
        final String websocketUrl = getWebsocketUrl(SpotApiConfig.class);
        return BinanceMarginApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    /**
     * Basic and simple create margin swap factory .
     *
     * @param apiKey
     * @param secretKey
     * @return instance of object extended BinanceFactory
     */
    public static BinanceSwapApiClientFactory createSwapFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(SpotApiConfig.class);
        return BinanceSwapApiClientFactory.newInstance(apiKey, secretKey, apiUrl);
    }

    /**
     * Basic and simple create futures engine factory .
     *
     * @param apiKey
     * @param secretKey
     * @return instance of object extended BinanceFactory
     */
    public static BinanceFuturesApiClientFactory createFuturesFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(FuturesApiConfig.class);
        final String websocketUrl = getWebsocketUrl(FuturesApiConfig.class);
        return BinanceFuturesApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    public static BinanceSavingApiClientFactory createSavingFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(SpotApiConfig.class);
        return BinanceSavingApiClientFactory.newInstance(apiKey, secretKey, apiUrl);
    }

    public static BinanceStakingApiClientFactory createStakingFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(SpotApiConfig.class);
        return BinanceStakingApiClientFactory.newInstance(apiKey, secretKey, apiUrl);
    }

    /**
     * Basic and simple create testnet engine factory .
     *
     * @param apiKey
     * @param secretKey
     * @return instance of object extended BinanceFactory
     */
    public static BinanceFuturesApiClientFactory createTestnetFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(TestnetApiConfig.class);
        final String websocketUrl = getWebsocketUrl(TestnetApiConfig.class);
        return BinanceFuturesApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    /**
     * @return instance of BinanceSpotApiClientFactory
     */
    public static BinanceSpotApiClientFactory createSpotFactory() {
        return createSpotFactory(null, null);
    }

    /**
     * @return instance of BinanceSpotApiClientFactory
     */
    public static BinanceFuturesApiClientFactory createFuturesFactory() {
        return createFuturesFactory(null, null);
    }

    /**
     * @return instance of BinanceSpotApiClientFactory
     */
    public static BinanceFuturesApiClientFactory createTestnetFactory() {
        return createTestnetFactory(null, null);
    }

    /**
     * get apiUrl from ApiConfig annotation
     *
     * @param apiConfigClass
     * @return apiUrl
     * @see ApiConfig
     */
    private static String getApiUrl(Class<? extends BinanceApiConfig> apiConfigClass) {
        return getApiConfig(apiConfigClass).apiUrl();
    }

    /**
     * get websocketUrl from ApiConfig annotation
     *
     * @param apiConfigClass
     * @return websocketUrl
     * @see ApiConfig
     */
    private static String getWebsocketUrl(Class<? extends BinanceApiConfig> apiConfigClass) {
        return getApiConfig(apiConfigClass).webSocketUrl();
    }

    /**
     * @param apiConfigClass
     * @return
     */
    private static ApiConfig getApiConfig(Class<? extends BinanceApiConfig> apiConfigClass) {
        if (apiConfigClass.isAnnotationPresent(ApiConfig.class)) {
            return apiConfigClass.getAnnotation(ApiConfig.class);
        } else {
            throw new BinanceIllegalException("Class should implemented BinanceApiConfig");
        }
    }

}
