package com.binance.api.client.impl;

import com.binance.api.client.api.BinanceApiError;
import com.binance.api.client.api.BinanceApiService;
import android.text.TextUtils;
import android.util.Log;

import com.binance.api.client.exception.BinanceApiException;
import com.binance.api.client.security.AuthenticationInterceptor;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Generates a Binance API implementation based on @see {@link BinanceApiService}.
 */
public class BinanceApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, BinanceApiError> errorBodyConverter =
            (Converter<ResponseBody, BinanceApiError>) converterFactory.responseBodyConverter(
                    BinanceApiError.class, new Annotation[0], null);

    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret, String apiUrl) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(converterFactory);

        if (TextUtils.isEmpty(apiKey) || TextUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    public static int limit;
    private final static int LimitPerMin = 1180;
    private static long limitStartTime;
    private static long limitEndTime;
    private static long timeDifferenceToServer;

    public static void setTimeDifferenceToServer(long time)
    {
        timeDifferenceToServer = time;
    }

    public static long getTimeDifferenceToServer() {
        return timeDifferenceToServer;
    }

    public static long getTime()
    {
        return System.currentTimeMillis() - timeDifferenceToServer;
    }

    private static void handelWeightLimit()
    {
        if (limit >= LimitPerMin) {

            try {
                long sleep = limitEndTime - System.currentTimeMillis();
                Log.d("executeSync", "limit reached wait " + sleep+"ms");
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void  parseWeightLimit(Response response)
    {
        Headers headerList = response.headers();
        try
        {
            List<String> l = headerList.values("x-mbx-used-weight");
            if (l != null && l.size() >= 1) {
                int li = Integer.parseInt(l.get(0));
                if (li < limit)
                {
                    limitStartTime = System.currentTimeMillis();
                    limitEndTime = limitStartTime + 60*1000;
                }
                limit = li;
                Log.d("executeSync", "limit: " + limit);
            }
        }
        catch (NullPointerException nullPointerException)
        {
        }
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            handelWeightLimit();
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                parseWeightLimit(response);
                return response.body();
            } else {
                BinanceApiError apiError = getBinanceApiError(response);
                throw new BinanceApiException(apiError);
            }
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }


    /**
     * Extracts and converts the response error body into an object.
     */
    public static BinanceApiError getBinanceApiError(Response<?> response) throws IOException, BinanceApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
