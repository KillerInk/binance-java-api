package com.binance.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [
 *   {
 *     "positionId":"123123",  //Staking position ID
 *     "projectId": "Axs*90",  //Staking project ID
 *     "asset":"AXS",          //Locked asset
 *     "amount":"122.09202928",  //Locked Amount
 *     "purchaseTime": "1646182276000",  //Subscription time
 *     "duration": "60",    //Lock period(days)
 *     "accrualDays": "4",  //Accrue days
 *     "rewardAsset":"AXS", //Earned asset
 *     "APY":"0.2032",
 *     "rewardAmt": "5.17181528",  //Earned amount
 *     "extraRewardAsset":"BNB",   //Rewards assets of extra staking type
 *     "extraRewardAPY":"0.0203",  //APY of extra staking type
 *     "estExtraRewardAmt": "5.17181528", //Rewards of extra staking type, distribute when order expires
 *     "nextInterestPay": "1.29295383",   //Next estimated interest payment
 *     "nextInterestPayDate": "1646697600000", //Next interest payment date
 *     "payInterestPeriod": "1",  //Interest cycle
 *     "redeemAmountEarly": "2802.24068892", //Early redemption amount
 *     "interestEndDate": "1651449600000",   //Interest accrual end date
 *     "deliverDate": "1651536000000",       //Redemption arrival time
 *     "redeemPeriod": "1",           //Redemption interval
 *     "redeemingAmt":"232.2323",     //Amount under redemption
 *     "partialAmtDeliverDate":"1651536000000", //Arrival time of partial redemption amount of order
 *     "canRedeemEarly": true,  //When it is true, early redemption can be operated
 *     "renewable"：true,  //When it is true, auto staking can be operated
 *     "type":"AUTO",   //Order type is auto-staking or normal
 *     "status": "HOLDING"
 *   }
 * ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingPosition
{
    @JsonProperty("positionId")
    String positionId;
    @JsonProperty("projectId")
    String projectId;
    @JsonProperty("asset")
    String asset;
    @JsonProperty("amount")
    String amount;
    @JsonProperty("purchaseTime")
    Long purchaseTime;
    @JsonProperty("duration")
    Long duration;
    @JsonProperty("accrualDays")
    Long accrualDays;
    @JsonProperty("rewardAsset")
    String rewardAsset;
    @JsonProperty("APY")
    String APY;
    @JsonProperty("rewardAmt")
    String rewardAmt;
    @JsonProperty("extraRewardAsset")
    String extraRewardAsset;
    @JsonProperty("extraRewardAPY")
    String extraRewardAPY;
    @JsonProperty("estExtraRewardAmt")
    String estExtraRewardAmt;
    @JsonProperty("nextInterestPay")
    String nextInterestPay;
    @JsonProperty("nextInterestPayDate")
    Long nextInterestPayDate;
    @JsonProperty("payInterestPeriod")
    String payInterestPeriod;
    @JsonProperty("redeemAmountEarly")
    String redeemAmountEarly;
    @JsonProperty("interestEndDate")
    Long interestEndDate;
    @JsonProperty("deliverDate")
    Long deliverDate;
    @JsonProperty("redeemPeriod")
    String redeemPeriod;
    @JsonProperty("redeemingAmt")
    String redeemingAmt;
    @JsonProperty("partialAmtDeliverDate")
    Long partialAmtDeliverDate;
    @JsonProperty("canRedeemEarly")
    String canRedeemEarly;
    @JsonProperty("renewable")
    String renewable;
    @JsonProperty("type")
    String type;
    @JsonProperty("status")
    String status;
}
