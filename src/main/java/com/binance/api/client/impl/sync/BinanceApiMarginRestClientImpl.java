package com.binance.api.client.impl.sync;

import com.binance.api.client.api.BinanceApiService;
import com.binance.api.client.api.sync.BinanceApiMarginRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.TransferType;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.impl.BinanceApiServiceGenerator;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.getTime;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiMarginRestClientImpl implements BinanceApiMarginRestClient {

    private final BinanceApiService binanceApiService;

    public BinanceApiMarginRestClientImpl(String apiKey, String secret, String apiUrl) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceApiService.class, apiKey, secret, apiUrl);
    }

    @Override
    public MarginAccount getAccount() {
        long timestamp = getTime();
        return executeSync(binanceApiService.getMarginAccount(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp));
    }

    @Override
    public List<Order> getOpenOrders(OrderRequest orderRequest) {
        return executeSync(binanceApiService.getOpenMarginOrders(orderRequest.getSymbol(), orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()));
    }

    @Override
    public MarginNewOrderResponse newOrder(MarginNewOrder order) {
        return executeSync(binanceApiService.newMarginOrder(order.getSymbol(), order.getSide(), order.getType(),
                order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
                order.getIcebergQty(), order.getNewOrderRespType(), order.getSideEffectType(), order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(binanceApiService.cancelMarginOrder(cancelOrderRequest.getSymbol(),
                cancelOrderRequest.getOrderId(), cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return executeSync(binanceApiService.getMarginOrderStatus(orderStatusRequest.getSymbol(),
                orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }

    @Override
    public MarginTransaction transfer(String asset, String amount, TransferType type) {
        long timestamp = getTime();
        return executeSync(binanceApiService.transfer(asset, amount, type.getValue(), BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp));
    }

    @Override
    public MarginTransaction borrow(String asset, String amount) {
        long timestamp = getTime();
        return executeSync(binanceApiService.borrow(asset, amount, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp));
    }

    @Override
    public LoanQueryResult queryLoan(String asset, String txId) {
        long timestamp = getTime();
        return executeSync(binanceApiService.queryLoan(asset, txId, timestamp));
    }

    @Override
    public RepayQueryResult queryRepay(String asset, String txId) {
        long timestamp = getTime();
        return executeSync(binanceApiService.queryRepay(asset, txId, timestamp));
    }

    @Override
    public RepayQueryResult queryRepay(String asset, long startTime) {
        long timestamp = getTime();
        return executeSync(binanceApiService.queryRepay(asset, startTime, timestamp));
    }

    @Override
    public MaxBorrowableQueryResult queryMaxBorrowable(String asset) {
        long timestamp = getTime();
        return executeSync(binanceApiService.queryMaxBorrowable(asset, timestamp));
    }

    @Override
    public MarginTransaction repay(String asset, String amount) {
        long timestamp = getTime();
        return executeSync(binanceApiService.repay(asset, amount, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp));
    }

    // user stream endpoints
    @Override
    public String startUserDataStream() {
        return executeSync(binanceApiService.startMarginUserDataStream()).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey) {
        executeSync(binanceApiService.keepAliveMarginUserDataStream(listenKey));
    }

    @Override
    public void closeUserDataStream(String listenKey) {
        executeSync(binanceApiService.closeAliveMarginUserDataStream(listenKey));
    }

}