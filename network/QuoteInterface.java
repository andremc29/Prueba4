package com.desafiolatam.prueba4.network;

import com.desafiolatam.prueba4.models.Quotes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by amuno on 12-11-2017.
 * traspaso a git
 */

public interface QuoteInterface {

    @GET(".")
    Call<Quotes> quotePpp();
}
