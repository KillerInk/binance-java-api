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
    public String positionId;
    @JsonProperty("projectId")
    public String projectId;
    @JsonProperty("asset")
    public String asset;
    @JsonProperty("amount")
    public String amount;
    @JsonProperty("purchaseTime")
    public Long purchaseTime;
    @JsonProperty("duration")
    public Long duration;
    @JsonProperty("accrualDays")
    public Long accrualDays;
    @JsonProperty("rewardAsset")
    public String rewardAsset;
    @JsonProperty("APY")
    public String APY;
    @JsonProperty("rewardAmt")
    public String rewardAmt;
    @JsonProperty("extraRewardAsset")
    public String extraRewardAsset;
    @JsonProperty("extraRewardAPY")
    public String extraRewardAPY;
    @JsonProperty("estExtraRewardAmt")
    public String estExtraRewardAmt;
    @JsonProperty("nextInterestPay")
    public String nextInterestPay;
    @JsonProperty("nextInterestPayDate")
    Long nextInterestPayDate;
    public @JsonProperty("payInterestPeriod")
    String payInterestPeriod;
    public @JsonProperty("redeemAmountEarly")
    String redeemAmountEarly;
    public @JsonProperty("interestEndDate")
    Long interestEndDate;
    public @JsonProperty("deliverDate")
    Long deliverDate;
    public @JsonProperty("redeemPeriod")
    String redeemPeriod;
    public @JsonProperty("redeemingAmt")
    String redeemingAmt;
    public @JsonProperty("partialAmtDeliverDate")
    Long partialAmtDeliverDate;
    public @JsonProperty("canRedeemEarly")
    String canRedeemEarly;
    public @JsonProperty("renewable")
    String renewable;
    public @JsonProperty("type")
    String type;
    public @JsonProperty("status")
    String status;
}
