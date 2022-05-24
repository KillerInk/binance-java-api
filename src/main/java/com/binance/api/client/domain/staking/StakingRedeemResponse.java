package com.binance.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingRedeemResponse {
    @JsonProperty("success")
    public String success;
}
