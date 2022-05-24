package com.binance.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [
 *   {
 *     "positionId":"123123",
 *     "time":1575018510000,
 *     "asset":"BNB",
 *     "project":"BSC", //DeFi Staking’s project
 *     "amount":"21312.23223",
 *     "lockPeriod":"30",
 *     "deliverDate":"1575018510000",  //Redemption date
 *     "type":"AUTO", // display only for subscription
 *     "status":"success"
 *   }
 * ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingRecord {
    @JsonProperty("positionId")
    public String positionId;
    @JsonProperty("time")
    public Long time;
    @JsonProperty("asset")
    public String asset;
    @JsonProperty("project")
    public String project;
    @JsonProperty("amount")
    public String amount;
    @JsonProperty("lockPeriod")
    public int lockPeriod;
    @JsonProperty("deliverDate")
    public Long deliverDate;
    @JsonProperty("type")
    public String type;
    @JsonProperty("status")
    public String status;
}
