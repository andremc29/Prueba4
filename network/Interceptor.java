package com.desafiolatam.prueba4.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amuno on 12-11-2017.
 *
 */

public class Interceptor {
    private final static String URL_BASE = "https://andruxnet-random-famous-quotes.p.mashape.com";


    public QuoteInterface InterceptorChange() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS);

        httpClient.addInterceptor(new okhttp3.Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder()
                        .header("X-Mashape-Key", "QbcR0zYkZQmshTyXTiQ4WpKrRGrlp1VHQvyjsnpQFuLXML7gDb")
                        .header("Accept", "application/json")
                        .build();

                Response response = chain.proceed(request);
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 4) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        QuoteInterface quoteInterface = interceptor.create(QuoteInterface.class);

        return quoteInterface;
    }





}
