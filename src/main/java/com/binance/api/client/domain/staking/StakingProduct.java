package com.binance.api.client.domain.staking;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [
 *     {
 *         "projectId": "Axs*90",
 *         "detail": {
 *             "asset":"AXS",       //Lock up asset
 *             "rewardAsset":"AXS", //Earn Asset
 *             "duration":90,       //Lock period(days)
 *             "renewable":true,    //Project supports renewal
 *             "apy": "1.2069"
 *         },
 *         "quota": {
 *             "totalPersonalQuota":"2",  //Total Personal quota
 *             "minimum":"0.001"          //Minimum amount per order
 *         }
 *     },
 *     {
 *         "projectId": "Fio*90",
 *         "detail": {
 *             "asset":"FIO",
 *             "rewardAsset":"FIO",
 *             "duration":90,
 *             "renewable":true,
 *             "apy":"1.0769"
 *         },
 *         "quota": {
 *             "totalPersonalQuota":"600",
 *             "minimum":"0.1"
 *         }
 *     }
 * ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakingProduct {

    @JsonProperty("projectId")
    public String projectID;
    @JsonProperty("detail")
    public Detail detail;
    @JsonProperty("quota")
    public Quota quota;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail
    {
        @JsonProperty("asset")
        public String asset;
        @JsonProperty("rewardAsset")
        public String reward_asset;
        @JsonProperty("duration")
        public int duration;
        @JsonProperty("renewable")
        public boolean renewable;
        @JsonProperty("apy")
        public long apy;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Quota
    {
        @JsonProperty("totalPersonalQuota")
        public long totalPersonalQuota;
        @JsonProperty("minimum")
        public long minimum;
    }
}
