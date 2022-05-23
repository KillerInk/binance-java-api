package com.binance.api.client.impl;

import com.binance.api.client.WalletEndpoint;
import com.binance.api.client.api.BinanceApiService;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.Deposit;
import com.binance.api.client.domain.account.FuturesTransactionHistory;
import com.binance.api.client.domain.account.FuturesTransactionList;
import com.binance.api.client.domain.account.Withdraw;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.createService;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.getTime;

public class WalletEndPointImpl implements WalletEndpoint
{
    private final BinanceApiService binanceApiService;

    public WalletEndPointImpl(BinanceApiService binanceApiService) {
        this.binanceApiService = binanceApiService;
    }

    @Override
    public List<Deposit> getDepositHistory(String asset, Integer status, Long startTime, Long endTime, Integer offset, Integer limit)
    {
        return executeSync(binanceApiService.getDepositHistory(asset,status,startTime,endTime,offset,limit, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                getTime()));
    }

    @Override
    public List<Deposit> getDepositHistory(String asset) {
        return getDepositHistory(asset,null,null,null,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(String asset,long startTime) {
        return getDepositHistory(asset,null,startTime,null,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(long endTime) {
        return getDepositHistory(null,null,null,endTime,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(long startTime,long endTime) {
        return getDepositHistory(null,null,startTime,endTime,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(String asset,long startTime,long endTime) {
        return getDepositHistory(asset,null,startTime,endTime,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory() {
        return getDepositHistory(null,null,null,null,null,null);
    }

    @Override
    public List<Withdraw> getWithdrawHistory(String asset) {
        return executeSync(binanceApiService.getWithdrawHistory(asset,null,null,null,null,null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                getTime()));
    }

    @Override
    public List<Withdraw> getWithdrawHistory(long startTime, long endTime) {
        return executeSync(binanceApiService.getWithdrawHistory(null,null,startTime,endTime,null,null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                getTime()));
    }

    @Override
    public FuturesTransactionList getFutureTransactionHistory(String asset, Long startTime, Long endTime, Long current, Long size) {
        return executeSync(binanceApiService.getFutureAccountTransactionHistoryList(asset,startTime,endTime,current,size,5000L,getTime()));
    }

    @Override
    public FuturesTransactionList getFutureTransactionHistory(String asset, Long startTime) {
        return getFutureTransactionHistory(asset,startTime,null,null,null);
    }

    @Override
    public FuturesTransactionList getFutureTransactionHistory(String asset,Long startTime, Long endtime) {
        return getFutureTransactionHistory(asset,startTime,endtime,null,null);
    }
}
