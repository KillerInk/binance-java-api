package com.binance.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [
 *   {
 *     "leftPersonalQuota": "1000" // User left quota
 *   }
 * ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingPersonalQuotaLeft {
    @JsonProperty("leftPersonalQuota")
    String leftPersonalQuota;
}
