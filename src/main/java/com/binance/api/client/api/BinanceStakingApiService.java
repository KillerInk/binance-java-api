package com.binance.api.client.api;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.staking.StakingPersonalQuotaLeft;
import com.binance.api.client.domain.staking.StakingPosition;
import com.binance.api.client.domain.staking.StakingProduct;
import com.binance.api.client.domain.staking.StakingPurchaseResponse;
import com.binance.api.client.domain.staking.StakingRecord;
import com.binance.api.client.domain.staking.StakingRedeemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BinanceStakingApiService {

    /**
         * GET /sapi/v1/staking/productList (HMAC SHA256)
         * Get available Staking product list
         *
         * Weight(IP): 1
         *
         * Parameters:
         * Name 	Type 	Mandatory 	Description
         * product 	ENUM 	YES 	"STAKING" for Locked Staking, "F_DEFI" for flexible DeFi Staking, "L_DEFI" for locked DeFi Staking
         * asset 	STRING 	NO
         * current 	LONG 	NO 	Currently querying page. Start from 1. Default:1
         * size 	LONG 	NO 	Default:10, Max:100
         * recvWindow 	LONG 	NO
         * timestamp 	LONG 	YES
         */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/staking/productList")
    Call<List<StakingProduct>> getStakingProductList (
            @Query("product") String product,
            @Query("asset") String asset,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /**
         * POST /sapi/v1/staking/purchase (HMAC SHA256)
         *
         * Weight(IP): 1
         *
         * Parameters:
         * Name 	Type 	Mandatory 	Description
         * product 	ENUM 	YES 	"STAKING" for Locked Staking, "F_DEFI" for flexible DeFi Staking, "L_DEFI" for locked DeFi Staking
         * productId 	STRING 	YES
         * amount 	DECIMAL 	YES
         * renewable 	STRING 	NO 	true or false, default false. Active if product is "STAKING" or "L_DEFI"
         * recvWindow 	LONG 	NO
         * timestamp 	LONG 	YES
         *
         *     You need to open Enable Spot & Margin Trading permission for the API Key which requests this endpoint.
         */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/staking/purchase")
    Call<StakingPurchaseResponse> purchaseStakingProduct(
            @Query("product") String product,
            @Query("productId") String productId,
            @Query("amount") Long amount,
            @Query("renewable") String renewable,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /**
         *  POST /sapi/v1/staking/redeem (HMAC SHA256)
         *
         * Redeem Staking product. Locked staking and Locked DeFI staking belong to early redemption, redeeming in advance will result in loss of interest that you have earned.
         *
         * Weight(IP): 1
         *
         * Parameters:
         * Name 	Type 	Mandatory 	Description
         * product 	ENUM 	YES 	"STAKING" for Locked Staking, "F_DEFI" for flexible DeFi Staking, "L_DEFI" for locked DeFi Staking
         * positionId 	STRING 	NO 	"1234", Mandatory if product is "STAKING" or "L_DEFI"
         * productId 	STRING 	YES
         * amount 	DECIMAL 	NO 	Mandatory if product is "F_DEFI"
         * recvWindow 	LONG 	NO
         * timestamp 	LONG 	YES
         *
         *     You need to open Enable Spot & Margin Trading permission for the API Key which requests this endpoint.
         */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/staking/redeem")
    Call<StakingRedeemResponse> redeemStakingProduct(
            @Query("product") String product,
            @Query("positionId") String positionId,
            @Query("productId") String productId,
            @Query("amount") Long amount,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /**
         *  GET /sapi/v1/staking/position (HMAC SHA256)
         *
         * Weight(IP): 1
         *
         * Parameters:
         * Name 	Type 	Mandatory 	Description
         * product 	ENUM 	YES 	"STAKING" for Locked Staking, "F_DEFI" for flexible DeFi Staking, "L_DEFI" for locked DeFi Staking
         * productId 	STRING 	NO
         * asset 	STRING 	NO
         * current 	LONG 	NO 	Currently querying the page. Start from 1. Default:1
         * size 	LONG 	NO 	Default:10, Max:100
         * recvWindow 	LONG 	NO
         * timestamp 	LONG 	YES
         */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/staking/position")
    Call<List<StakingPosition>> getPositionsStaking(
            @Query("product") String product,
            @Query("productId") String productId,
            @Query("asset") String asset,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /**
         *  GET /sapi/v1/staking/stakingRecord (HMAC SHA256)
         *
         * Weight(IP): 1
         *
         * Parameters:
         * Name 	Type 	Mandatory 	Description
         * product 	ENUM 	YES 	"STAKING" for Locked Staking, "F_DEFI" for flexible DeFi Staking, "L_DEFI" for locked DeFi Staking
         * txnType 	ENUM 	YES 	"SUBSCRIPTION", "REDEMPTION", "INTEREST"
         * asset 	STRING 	NO
         * startTime 	LONG 	NO
         * endTime 	LONG 	NO
         * current 	LONG 	NO 	Currently querying the page. Start from 1. Default:1
         * size 	LONG 	NO 	Default:10, Max:100
         * recvWindow 	LONG 	NO
         * timestamp 	LONG 	YES
         *
         *     The time between startTime and endTime cannot be longer than 3 months.
         *     If startTime and endTime are both not sent, then the last 30 days' data will be returned.
         */

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/staking/stakingRecord")
    Call<List<StakingRecord>> getStakingRecord(
            @Query("product") String product,
            @Query("txnType") String txnType,
            @Query("asset") String asset,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /*
    POST /sapi/v1/staking/setAutoStaking (HMAC SHA256)

    Set auto staking on Locked Staking or Locked DeFi Staking

    Weight(IP): 1

    Parameters:
    Name 	Type 	Mandatory 	Description
    product 	ENUM 	YES 	"STAKING" for Locked Staking, "L_DEFI" for locked DeFi Staking
    positionId 	STRING 	YES
    renewable 	STRING 	YES 	true or false
    recvWindow 	LONG 	NO
    timestamp 	LONG 	YES
     */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/staking/setAutoStaking")
    Call<StakingRedeemResponse> setAutoStaking(
            @Query("product") String product,
            @Query("positionId") String positionId,
            @Query("renewable") String renewable,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /**
        *  GET /sapi/v1/staking/personalLeftQuota(HMAC SHA256)
         *
         * Weight(IP): 1
         *
         * Parameters:
         * Name 	Type 	Mandatory 	Description
         * product 	ENUM 	YES 	"STAKING" for Locked Staking, "F_DEFI" for flexible DeFi Staking, "L_DEFI" for locked DeFi Staking
         * productId 	STRING 	YES
         * recvWindow 	LONG 	NO
         * timestamp 	LONG 	YES
        */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/staking/personalLeftQuota")
    Call<StakingPersonalQuotaLeft> getPersonalQuotaLeft(
            @Query("product") String product,
            @Query("productId") String productId,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

}
