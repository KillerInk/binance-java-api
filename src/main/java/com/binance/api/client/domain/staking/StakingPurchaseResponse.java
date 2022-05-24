package com.binance.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 {
 "positionId":"12345",
 "success":true
 }

 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingPurchaseResponse {
    @JsonProperty("postitionId")
    public int postitionId;
    @JsonProperty("success")
    public String success;
}
