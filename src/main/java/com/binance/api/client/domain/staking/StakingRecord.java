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
    String positionId;
    @JsonProperty("time")
    Long time;
    @JsonProperty("asset")
    String asset;
    @JsonProperty("project")
    String project;
    @JsonProperty("amount")
    String amount;
    @JsonProperty("lockPeriod")
    int lockPeriod;
    @JsonProperty("deliverDate")
    Long deliverDate;
    @JsonProperty("type")
    String type;
    @JsonProperty("status")
    String status;
}
